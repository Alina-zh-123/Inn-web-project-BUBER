package com.zhilyuk.task4.command;

public enum CommandType {
    SIGN_IN(new SignInCommand()),
    SIGN_UP(new SignUpCommand()),
    SIGN_OUT(new SignOutCommand()),
    MAKE_REQUEST_FOR_ORDER(new MakeRequestForOrderCommand()),
    MAKE_ORDER(new MakeOrderCommand()),
    DECLINE_ORDER(new DeclineOrderCommand());

    private final Command command;

    CommandType(Command command) {
        this.command = command;
    }

    public static Command define(String commandStr) {
        return CommandType.valueOf(commandStr.toUpperCase()).command;
    }
}
