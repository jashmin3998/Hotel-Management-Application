INSERT INTO roles(name) VALUES('ROLE_USER');
INSERT INTO roles(name) VALUES('ROLE_EMPLOYEE');
--
insert into users (email, password, username, reward_points, phone_number, address) values('employee@gmail.com', '$2a$10$Fu4GqNJie.NAQayS8tD0VOWQM4iIjl5brVoeRl8jMoOalQJkQYaVG', 'employee', 100, '1234567890', 'abcdfghjkl');
insert into user_roles (user_id, role_id) values (1, 2);

INSERT INTO hotel(country, hotelname, price, rating, state) VALUES('USA','ABCDR',1500,4,'California');
INSERT INTO hotel(country, hotelname, price, rating, state) VALUES('USA','xyz',1500,4,'Arizona');
INSERT INTO hotel(country, hotelname, price, rating, state) VALUES('USA','jkl',1500,4,'Texas');
INSERT INTO hotel(country, hotelname, price, rating, state) VALUES('INDIA','poi',1500,4,'Gujarat');
INSERT INTO hotel(country, hotelname, price, rating, state) VALUES('UK','ertyy',1500,4,'London');
INSERT INTO hotel(country, hotelname, price, rating, state) VALUES('CANADA','optionssae',1500,3,'Torronto');
INSERT INTO hotel(country, hotelname, price, rating, state) VALUES('CANADA','lkjhgasd',1500,6,'Vancover');

INSERT INTO room(name, price, hotel_id, available_rooms) VALUES('ROOM_SINGLE',1500, 1, 5);
--INSERT INTO room(name, price, hotel_id, availableRooms) VALUES('ROOM_DOUBLE',3000, 1, 10);
INSERT INTO room(name, price, hotel_id, available_rooms) VALUES('ROOM_SUITS',4500, 1, 20);

INSERT INTO room(name, price, hotel_id, available_rooms) VALUES('ROOM_SINGLE',1500, 2, 15);
INSERT INTO room(name, price, hotel_id, available_rooms) VALUES('ROOM_DOUBLE',3000, 2, 15);
--INSERT INTO room(name, price, hotel_id, available_rooms) VALUES('ROOM_SUITS',4500, 2, 15);

--INSERT INTO room(name, price, hotel_id, available_rooms) VALUES('ROOM_SINGLE',1500, 3, 15);
--INSERT INTO room(name, price, hotel_id, available_rooms) VALUES('ROOM_DOUBLE',3000, 3, 15);
--INSERT INTO room(name, price, hotel_id, available_rooms) VALUES('ROOM_SUITS',4500, 3, 15);

--INSERT INTO room(name, price, hotel_id, available_rooms) VALUES('ROOM_SINGLE',1500, 4, 15);
INSERT INTO room(name, price, hotel_id, available_rooms) VALUES('ROOM_DOUBLE',3000, 4, 15);
INSERT INTO room(name, price, hotel_id, available_rooms) VALUES('ROOM_SUITS',4500, 4, 15);

--INSERT INTO room(name, price, hotel_id, available_rooms) VALUES('ROOM_SINGLE',1500, 5, 15);
--INSERT INTO room(name, price, hotel_id, available_rooms) VALUES('ROOM_DOUBLE',3000, 5, 15);
--INSERT INTO room(name, price, hotel_id, available_rooms) VALUES('ROOM_SUITS',4500, 5, 15);

INSERT INTO room(name, price, hotel_id, available_rooms) VALUES('ROOM_SINGLE',1500, 6, 15);
INSERT INTO room(name, price, hotel_id, available_rooms) VALUES('ROOM_DOUBLE',3000, 6, 15);
INSERT INTO room(name, price, hotel_id, available_rooms) VALUES('ROOM_SUITS',4500, 6, 15);

INSERT INTO room(name, price, hotel_id, available_rooms) VALUES('ROOM_SINGLE',1500, 7, 10);
INSERT INTO room(name, price, hotel_id, available_rooms) VALUES('ROOM_DOUBLE',3000, 7, 20);
INSERT INTO room(name, price, hotel_id, available_rooms) VALUES('ROOM_SUITS',4500, 7, 16);



INSERT INTO Amenities(name, hotel_id) VALUES('FITNESS_ROOM', 1);
INSERT INTO Amenities(name, hotel_id) VALUES('JACCUZZI', 1);
INSERT INTO Amenities(name, hotel_id) VALUES('BREAKFAST', 1);


INSERT INTO Amenities(name, hotel_id) VALUES('FITNESS_ROOM', 2);
INSERT INTO Amenities(name, hotel_id) VALUES('JACCUZZI', 2);
INSERT INTO Amenities(name, hotel_id) VALUES('BREAKFAST', 2);


INSERT INTO Amenities(name, hotel_id) VALUES('FITNESS_ROOM', 3);
INSERT INTO Amenities(name, hotel_id) VALUES('JACCUZZI', 3);
INSERT INTO Amenities(name, hotel_id) VALUES('BREAKFAST', 3);


INSERT INTO Amenities(name, hotel_id) VALUES('FITNESS_ROOM', 4);
INSERT INTO Amenities(name, hotel_id) VALUES('JACCUZZI', 4);
INSERT INTO Amenities(name, hotel_id) VALUES('BREAKFAST', 4);


INSERT INTO Amenities(name, hotel_id) VALUES('FITNESS_ROOM', 5);
INSERT INTO Amenities(name, hotel_id) VALUES('JACCUZZI', 5);
INSERT INTO Amenities(name, hotel_id) VALUES('BREAKFAST', 5);



--INSERT INTO HOTEL_AMENITIES(hotel_id, amenities_id) VALUES(1,2);
--INSERT INTO HOTEL_AMENITIES(hotel_id, amenities_id) VALUES(2,1);
--INSERT INTO HOTEL_AMENITIES(hotel_id, amenities_id) VALUES(1,1);
--INSERT INTO HOTEL_AMENITIES(hotel_id, amenities_id) VALUES(2,2);
--INSERT INTO HOTEL_AMENITIES(hotel_id, amenities_id) VALUES(3,1);
--INSERT INTO HOTEL_AMENITIES(hotel_id, amenities_id) VALUES(2,3);
--INSERT INTO HOTEL_AMENITIES(hotel_id, amenities_id) VALUES(3,2);
--INSERT INTO HOTEL_AMENITIES(hotel_id, amenities_id) VALUES(3,3);

--INSERT INTO HOTEL_ROOMS(hotel_id, room_id) VALUES(1,2);
--INSERT INTO HOTEL_ROOMS(hotel_id, room_id) VALUES(2,2);
--INSERT INTO HOTEL_ROOMS(hotel_id, room_id) VALUES(3,2);
--INSERT INTO HOTEL_ROOMS(hotel_id, room_id) VALUES(1,1);
--INSERT INTO HOTEL_ROOMS(hotel_id, room_id) VALUES(2,1);
--INSERT INTO HOTEL_ROOMS(hotel_id, room_id) VALUES(3,1);
--INSERT INTO HOTEL_ROOMS(hotel_id, room_id) VALUES(1,3);
--INSERT INTO HOTEL_ROOMS(hotel_id, room_id) VALUES(2,3);
--INSERT INTO HOTEL_ROOMS(hotel_id, room_id) VALUES(3,3);


--
--insert into booking(no_of_adults, no_of_childrens, hotel_id, user_id) values (1, 0, 1, 1);
--insert into booking_amenities(booking_id, amenities_id) values (1, 1);
--insert into booking_amenities(booking_id, amenities_id) values (1, 2);
--insert into booking_amenities(booking_id, amenities_id) values (1, 3);
--
--insert into booking_rooms(booking_id, room_id) values (1, 1);










