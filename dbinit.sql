CREATE TABLE ROOM (
	ROOM_ID integer auto_increment primary key,
	ROOM_TITLE varchar(1000),
	ROOM_DESCRIPTION varchar(8000)
);

CREATE TABLE ROOM_EXTRA (
	ROOM_ID_FK integer references ROOM (ROOM_ID),
	EXTRA_ID_FK integer references EXTRA (EXTRA_ID)
);

CREATE TABLE EXTRA (
	EXTRA_ID integer auto_increment primary key,
	EXTRA_NAME varchar(1000)
);

CREATE TABLE GUEST (
	GUEST_ID integer auto_increment primary key,
	GUEST_NAME varchar(1000),
	GUEST_SURNAME varchar(1000),
	GUEST_EMAIL varchar(1000)
);

CREATE TABLE BOOKING (
	BOOKING_ID integer auto_increment primary key,
	ROOM_ID_FK integer references ROOM (ROOM_ID),
	GUEST_ID_FK integer references GUEST (GUEST_ID),
	BOOKING_DATE_START datetime,
	BOOKING_DATE_END datetime,
	BREAKFAST bool
);

CREATE TABLE HOTEL_INFO (
	INFO_ID integer auto_increment primary key,
	INFO_KEY varchar(1000),
	INFO_VALUE varchar(8000)
);
