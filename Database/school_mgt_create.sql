Create table Student(
	student_id integer primary key auto_increment,
    firstname varchar(20),
    lastname varchar(20),
    date_of_birth date,
    age integer,
    yeargroup integer,
    nationality varchar(30)
    
);

create table staff(
	staff_id integer primary key auto_increment,
    firstname varchar(20),
    lastname varchar(20),
    subjects varchar(20),
    employment_date date,
    department enum('teacher','other staff')
    
);

create table classes(
	class_id integer primary key,
    class enum('1','2','3','4','5','6','JSS 1', 'JSS 2', 'JSS 3')

);

create table stream(
	stream_id integer primary key,
    stream_type enum('a','b')
);

create table subjects(
	subject_id integer primary key,
    subname varchar(20),
    subcode integer,
    department varchar(20),
    teacher_id integer,
    foreign key (teacher_id) references staff (staff_id)
);

create table report(
	report_id integer primary key,
    stud_id integer,
    class_id integer,
    sub_id integer,
    remark varchar(50),
    stream integer,
    mark integer,
    class_teacher integer,
    foreign key (stud_id) references student (student_id),
    foreign key (class_id) references classes (class_id),
    foreign key (stream) references stream (stream_id),
    foreign key (class_teacher) references staff(staff_id)
    
);

create table fee(
	fee_id integer primary key,
    stud_id integer,
    class_id integer,
    stream_id integer,
    amount decimal(10,2),
    date_paid date,
	balance integer,
    payment_type enum('full', 'part'),
    foreign key (class_id) references classes(class_id),
    foreign key (stream_id) references stream (stream_id),
    foreign key (stud_id) references student (student_id)
   
);

create table grade(
	grade_id int primary key,
    letter_grade enum('A','B','C','D','E','F'),
    stud_id integer,
    mark integer,
    sub_id integer,
    foreign key (stud_id) references student (student_id),
    foreign key (sub_id) references subjects (subject_id)

);

create table login(
	login_id integer primary key,
	username_low varchar(30)
);