package cn.yano.modules.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * ZIP压缩工具
 * Created by xieyangyang0636 on 2020/1/19.
 */
public class ZipUtil {
    /**
     * 日志Logger
     */
    private final static Logger log = LoggerFactory.getLogger(ZipUtil.class);
    /**
     * 目的地Zip文件
     */
    private String zipFileName;
    /**
     * 源文件
     */
    private String sourceFileName;
    /**
     * 压缩完是否删除
     */
    private boolean deleteFlag;

    /**
     * 构造方法
     *
     * @param zipFileName    目的地Zip文件
     * @param sourceFileName 源文件
     */
    public ZipUtil(String zipFileName, String sourceFileName) {
        this.zipFileName = zipFileName;
        this.sourceFileName = sourceFileName;
        this.deleteFlag = false;
    }

    /**
     * 构造方法
     *
     * @param zipFileName    目的地Zip文件
     * @param sourceFileName 源文件
     * @param deleteFlag     压缩完是否删除
     */
    public ZipUtil(String zipFileName, String sourceFileName, boolean deleteFlag) {
        this.zipFileName = zipFileName;
        this.sourceFileName = sourceFileName;
        this.deleteFlag = deleteFlag;
    }

    /**
     * 压缩方法
     *
     * @throws Exception
     */
    public void compress() throws Exception {
        log.info("##### 压缩中...");
        ZipOutputStream out = new ZipOutputStream(new FileOutputStream(zipFileName));
        BufferedOutputStream bos = new BufferedOutputStream(out);
        File sourceFile = new File(sourceFileName);
        compress(out, bos, sourceFile, sourceFile.getName());
        bos.close();
        out.close();
        log.info("##### 压缩完成");
        if (deleteFlag) {
            log.info("##### 清除源数据");
            delete(sourceFile);
        }
    }

    /**
     * 执行压缩方法
     *
     * @param out
     * @param bos
     * @param sourceFile
     * @param base
     * @throws Exception
     */
    private void compress(ZipOutputStream out, BufferedOutputStream bos, File sourceFile, String base)
            throws Exception {
        if (sourceFile.isDirectory()) {
            File[] flist = sourceFile.listFiles();
            if (flist.length == 0) {
                log.info("##### 发现文件夹" + base + "/");
                out.putNextEntry(new ZipEntry(base + "/"));
            } else {
                for (int i = 0; i < flist.length; i++) {
                    compress(out, bos, flist[i], base + "/" + flist[i].getName());
                }
            }
        } else {
            out.putNextEntry(new ZipEntry(base));
            FileInputStream fos = new FileInputStream(sourceFile);
            BufferedInputStream bis = new BufferedInputStream(fos);
            int tag;
            log.info("##### 添加" + base);
            while ((tag = bis.read()) != -1) {
                out.write(tag);
            }
            bis.close();
            fos.close();
        }
    }

    /**
     * 递归删除文件夹
     *
     * @param file 文件夹
     * @return 是否成功
     */
    private boolean delete(File file) {
        if (file.isDirectory()) {
            String[] children = file.list();
            for (int i = 0; i < children.length; i++) {
                boolean success = delete(new File(file, children[i]));
                if (!success) {
                    return false;
                }
            }
        }
        log.info("##### 删除 " + file.getPath());
        return file.delete();
    }

}
