package com.terapico.utils;

public class EnvUtil {
    /**
     * 规则:<ul>
     *     <li>如果 inputValue 有值,且不是"env:"开头, 就使用这个值</li>
     *     <li>如果 inputValue 有值,且为 "env:" 开头, 则使用其指定的环境变量</li>
     *     <li>如果有环境变量,取环境变量的值</li>
     *     <li>如果没有inputValue中没有指定环境变量,则取defaultEnvVariable对应的环境变量的值</li>
     *     <li>还是取不到,返回defaultValue</li>
     * </ul>
     * @param inputValue
     * @param defaultEnvVariable
     * @param defaultValue
     * @return
     */
    public static String getValueFromEnv(String inputValue, String defaultEnvVariable, String defaultValue) {
        if (inputValue != null && !inputValue.startsWith("env:")) {
            return inputValue;
        }
        String envVarName = null;
        if (inputValue != null && inputValue.startsWith("env:")) {
            envVarName = inputValue.substring(4);
            return getEnvVariable(envVarName, defaultValue);
        }
        return getEnvVariable(defaultEnvVariable, defaultValue);
    }

    /**
     * 先获取 -D{envVarName} 对应的值, 不行再取环境变量,还不行返回默认值
     * @param envVarName
     * @param defaultValue
     * @return
     */
    public static String getEnvVariable(String envVarName, String defaultValue) {
        if (envVarName == null) {
            return defaultValue;
        }
        String val = System.getProperty(envVarName);
        if (val != null) {
            return val;
        }
        val = System.getenv(envVarName);
        if (val != null) {
            return val;
        }
        return defaultValue;
    }
}
