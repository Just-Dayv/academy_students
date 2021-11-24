CREATE TABLE `faculty` (
    `id` int NOT NULL AUTO_INCREMENT,
    `name` varchar(20) NOT NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE `departmentEntity` (
    `id` int NOT NULL AUTO_INCREMENT,
    `name` varchar(20) NOT NULL,
    `faculty_id` int NOT NULL,
    PRIMARY KEY (`id`),
    KEY `faculty_id` (`faculty_id`),
    CONSTRAINT `department_ibfk_1` FOREIGN KEY (`faculty_id`) REFERENCES `facultyEntity` (`id`)
);


CREATE TABLE `student` (
    `id` int NOT NULL AUTO_INCREMENT,
    `first_name` varchar(15) NOT NULL,
    `last_name` varchar(15) NOT NULL,
    `gender` varchar(1) NOT NULL,
    `dob` date NOT NULL,
    `department_id` int NOT NULL,
    PRIMARY KEY (`id`),
    KEY `department_id` (`department_id`),
    CONSTRAINT `student_ibfk_1` FOREIGN KEY (`department_id`) REFERENCES `departmentEntity` (`id`)
);

