create table member
(
    id int auto_increment,
    email varchar(20) not null,
    nickname varchar(20) not null,
    birthday date not null,
    created_at datetime not null,
    constraint member_id_uindex
        primary key (id)
);

create table member_nickname_history
(
    id int auto_increment,
    member_id int not null,
    nickname varchar(20) not null,
    created_at datetime not null,
    constraint member_nickname_history_id_uindex
        primary key (id)
);

create table follow
(
    id int auto_increment,
    fromMemberId int not null,
    toMemberId int not null,
    created_at datetime not null,
    constraint follow_id_uindex
        primary key (id)
);

create unique index Follow_fromMemberId_toMemberId_uindex
    on follow (fromMemberId, toMemberId);


create table post
(
    id int auto_increment,
    memberId int not null,
    contents varchar(100) not null,
    created_date date not null,
    created_at datetime not null,
    constraint post_id_uindex
        primary key (id)
);

alter table post add column likeCount int;

alter table post add column version int default 0;

create index post__index_member_id
    on post (memberId);

create index post__index_created_date
    on post (created_date);

create index post__index_member_id_created_date
    on post (memberId, created_date);

create table timeline
(
    id int auto_increment,
    memberId int not null,
    postId int not null,
    created_at datetime not null,
    constraint timeline_id_uindex
        primary key (id)
);


create table post_like
(
    id int auto_increment,
    memberId int not null,
    postId int not null,
    created_at datetime not null,
    constraint post_like_id_uindex
        primary key (id)
);
