package cn.yano.modules.utils;

import org.apache.avro.Schema;
import org.apache.avro.io.BinaryEncoder;
import org.apache.avro.io.Decoder;
import org.apache.avro.io.DecoderFactory;
import org.apache.avro.io.EncoderFactory;
import org.apache.avro.specific.SpecificDatumReader;
import org.apache.avro.specific.SpecificDatumWriter;
import org.apache.avro.specific.SpecificRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by xieyangyang0636 on 2020/1/19.
 */

public class AvroUtil {
    private static final Logger logger = LoggerFactory.getLogger(AvroUtil.class);

    public AvroUtil() {
    }

    public static <T extends SpecificRecord> byte[] serialize(T srBean) {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        BinaryEncoder encoder = EncoderFactory.get().binaryEncoder(out, (BinaryEncoder) null);
        SpecificDatumWriter writer = new SpecificDatumWriter(srBean.getSchema());

        try {
            writer.write(srBean, encoder);
            encoder.flush();
            out.close();
            byte[] e = out.toByteArray();
            return e;
        } catch (IOException e) {
            logger.error("failed to serialize the bean to bytes,{}", e.getMessage());
            return null;
        }
    }


    public static <T extends SpecificRecord> T deserialize(byte[] serializedBytes, Schema schema) throws IOException {
        SpecificDatumReader<T> reader = new SpecificDatumReader<T>(schema);
        Decoder decoder = DecoderFactory.get().binaryDecoder(serializedBytes, null);
        T result = reader.read(null, decoder);
        return result;
    }

    public static Schema getSchema(String avscFile) {
        try (InputStream is = new FileInputStream(avscFile)) {
            Schema parsedSchema = new Schema.Parser().parse(is);
            return parsedSchema;
        } catch (IOException e) {
            logger.error("failed to load or parse the schema file,{}", e.getMessage());
            throw new RuntimeException(e.getMessage(), e.getCause());
        }
    }
}