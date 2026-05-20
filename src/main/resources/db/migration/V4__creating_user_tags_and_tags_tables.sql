-- Create the tags table
create table tags
(
    id   BIGINT auto_increment
        primary key,
    name varchar(255) not null
);

-- Create the user_tags join table
create table user_tags
(
    user_id BIGINT not null,
    tag_id  BIGINT    not null,
    constraint user_tags_pk
        primary key (tag_id, user_id),
    constraint user_tags_tags_id_fk
        foreign key (tag_id) references tags (id)
            on delete cascade,
    constraint user_tags_users_id_fk
        foreign key (user_id) references users (id)
            on delete cascade
);
