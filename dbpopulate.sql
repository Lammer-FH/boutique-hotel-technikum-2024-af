TRUNCATE TABLE ROOM_EXTRA;
TRUNCATE TABLE EXTRA;
TRUNCATE TABLE ROOM;


INSERT INTO ROOM (ROOM_ID, ROOM_TITLE, ROOM_DESCRIPTION) VALUES 
(1, 'Single room without extras', 'Beautiful room, beautiful view, small but nice, some text'), 
(2, 'Single room with extras', 'Beautiful room, beautiful view, small but many thangs, some text'),
(3, 'Single room A', 'Nice room, beautiful view, small but many thangs, some text'),
(4, 'Single room B', 'Beautiful room, beautiful view, small but many thangs, some text'),
(5, 'Double room A', 'Nice room, beautiful view, small but many thangs, some text'),
(6, 'Double room B', 'Beautiful room, beautiful view, small but many thangs, some text');

INSERT INTO EXTRA (EXTRA_ID, EXTRA_NAME) VALUES 
(1, 'Free WiFi'), 
(2, 'Air conditioning'), 
(3, 'Mini bar'), 
(4, 'Noise protection'), 
(5, 'TV'), 
(6, 'Barrier-free');

INSERT INTO ROOM_EXTRA (ROOM_ID_FK, EXTRA_ID_FK) VALUES
(1, 1),
(1, 2),
(1, 3),
(1, 4),
(1, 5),
(1, 6);


