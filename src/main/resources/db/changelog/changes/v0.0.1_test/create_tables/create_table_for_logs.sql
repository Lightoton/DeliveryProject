CREATE TABLE logging_event
(
    timestamp          TIMESTAMP    NOT NULL,
    formatted_message TEXT         NOT NULL,
    logger_name       VARCHAR(128) NOT NULL,
    level_string      VARCHAR(10)  NOT NULL,
    thread_name       VARCHAR(255),
    reference_flag    SMALLINT,
    arg0              VARCHAR(255),
    arg1              VARCHAR(255),
    arg2              VARCHAR(255),
    arg3              VARCHAR(255),
    caller_filename   VARCHAR(255) NOT NULL,
    caller_class      VARCHAR(128) NOT NULL,
    caller_method     VARCHAR(255) NOT NULL,
    caller_line       CHAR(4)      NOT NULL
);
