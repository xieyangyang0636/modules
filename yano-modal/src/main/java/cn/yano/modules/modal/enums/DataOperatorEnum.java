package cn.yano.modules.modal.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * 数据处理类型
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
public enum DataOperatorEnum {
    /**
     * 等于
     */
    EQUALS("e", "等于"),
    /**
     * 为空
     */
    EMPTY("empty", "为空"),
    /**
     * 不为空
     */
    NOT_EMPTY("nempty", "不为空"),
    /**
     * 大于
     */
    GREATER_THAN("gt", "大于"),
    /**
     * 大于等于
     */
    GREATER_THAN_OR_EQUALS("gte", "大于等于"),
    /**
     * 小于
     */
    LESS_THAN("lt", "小于"),
    /**
     * 小于等于
     */
    LESS_THAN_OR_EQUALS("lte", "小于等于"),
    /**
     * 不等于
     */
    NOT_EQUALS("ne", "不等于"),
    /**
     * 包含
     */
    CONTAINS("contains", "包含"),
    /**
     * 等于
     */
    NOT_CONTAINS("ncontains", "不包含");

    private String code;
    private String name;

    DataOperatorEnum(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public static Map<String, String> NAME_MAP = new HashMap<String, String>() {

        private static final long serialVersionUID = -2462106087926359044L;

        {
            for (DataOperatorEnum dataOperatorEnum : DataOperatorEnum.values()) {
                put(dataOperatorEnum.getCode(), dataOperatorEnum.getName());
            }
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
