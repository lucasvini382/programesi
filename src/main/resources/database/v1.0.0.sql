CREATE TABLE IF NOT EXISTS pgs_usr_user(
                                           usr_id serial not null constraint pgs_usr_user_pk primary key,
                                           usr_login VARCHAR,
                                           usr_password VARCHAR,
                                           usr_first_name VARCHAR,
                                           usr_last_name VARCHAR
);

CREATE TABLE IF NOT EXISTS pgs_tiw_time_work(
                                                tiw_id serial not null constraint pgs_tiw_time_work_pk primary key,
                                                tiw_entry_hour VARCHAR,
                                                tiw_exit_hour VARCHAR,
                                                tiw_description VARCHAR,
                                                tiw_initials VARCHAR,
                                                tiw_user_id INTEGER
);

alter table pgs_tiw_time_work
    add constraint fk_tiw_login_id_log_id foreign key (tiw_user_id) references pgs_usr_user (usr_id);

CREATE TABLE IF NOT EXISTS pgs_cal_calendar(
                                                cal_id serial not null constraint pgs_cal_calendar_pk primary key,
                                                cal_date DATE,
                                                cal_time_work_id INTEGER
);

alter table pgs_cal_calendar
    add constraint fk_cal_calendar_id_tiw_id foreign key (cal_time_work_id) references pgs_tiw_time_work (tiw_id);