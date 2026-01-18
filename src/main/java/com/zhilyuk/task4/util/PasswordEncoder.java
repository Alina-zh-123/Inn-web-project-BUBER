package com.zhilyuk.task4.util;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class PasswordEncoder {
    public String hashPassword(String password) {
        byte[] passwordBytes = password.getBytes(StandardCharsets.UTF_8);
        return Base64.getEncoder().encodeToString(passwordBytes);
    }
}


