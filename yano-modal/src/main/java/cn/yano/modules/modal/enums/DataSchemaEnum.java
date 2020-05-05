package cn.yano.modules.modal.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * 数据Schema
 *
 * @ProductName: Hundsun MATCH
 * @ProjectName: rcmd-modal
 * @Package: com.hundsun.rcmd.enums
 * @Description: note
 * @Author: xieyy23076
 * @CreateDate: 2019/11/6 15:54
 * @UpdateUser: xieyy23076
 * @UpdateDate: 2019/11/6 15:54
 * @UpdateRemark:
 * @Version: 1.0
 * <p>
 * Copyright © 2019 Hundsun Technologies Inc. All Rights Reserved
 **/
public enum DataSchemaEnum {
    /**
     * kafka 资讯流
     */
    KAFKA_GENERALNEWSINFO(1, "GeneralNewsInfo");

    private Integer type;
    private String name;

    DataSchemaEnum(int type, String name) {
        this.type = type;
        this.name = name;
    }

    public static Map<Integer, String> NAME_MAP = new HashMap<Integer, String>() {

        private static final long serialVersionUID = -2462106087926359044L;

        {
            for (DataSchemaEnum dataSchemaEnum : DataSchemaEnum.values()) {
                put(dataSchemaEnum.getType(), dataSchemaEnum.getName());
            }
        }
    };

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
