create schema climbing_show;

use climbing_show;

create table climbing_infos
(
    id           bigint auto_increment
        primary key,
    name         varchar(100) not null comment '클라이밍장 이름',
    address_road text         not null comment '도로명 주소',
    address_lot  text         null comment '지번 주소',
    latitude     varchar(15)  not null comment '위도',
    longitude    varchar(15)  not null comment '경도',
    logo_url     text         null comment '클라이밍장 로고',
    constraint name_idx
        unique (name)
) comment '클라이밍 정보';

create table climbing_level
(
    id               bigint auto_increment
        primary key,
    climbing_info_id bigint      not null,
    level            int         not null comment '레벨',
    color            varchar(15) not null comment '색상',
    constraint cl_ci_fk
        foreign key (climbing_info_id) references climbing_infos (id)
) comment '클라이밍장 레벨';