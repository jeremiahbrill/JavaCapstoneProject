BEGIN TRANSACTION;

DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS Category;
DROP TABLE IF EXISTS Workflow;
DROP TABLE IF EXISTS Subworkflow;
DROP TABLE IF EXISTS jobs;
DROP TABLE IF EXISTS jobPosition;

CREATE TABLE users (
  id serial PRIMARY KEY,
  username varchar(255) NOT NULL UNIQUE,     -- Username
  password varchar(32) NOT NULL,      -- Password
  salt varchar(256) NOT NULL,          -- Password Salt
  role varchar(255) NOT NULL default('user'),
  firstname varchar(255),
  lastname varchar(255),
  avatar varchar(255),
  jobselection varchar(255)
);

CREATE TABLE Category (
  Category_ID serial,
  Name varchar(255) NOT NULL UNIQUE,
  Presentation_Text varchar(255) NOT NULL,

  constraint pk_Category primary key (Category_ID)
);

CREATE TABLE Workflow (
  Workflow_ID serial,
  Name varchar(255) NOT NULL,
  Category_ID int,
  Presentation_Text varchar(255) NOT NULL,

  constraint pk_Workflow primary key (Workflow_ID),
  constraint fk_Workflow_Category foreign key (Category_ID) references Category  (Category_ID)
);

CREATE TABLE SubWorkflow (
  SubWorkflow_ID serial,
  Name varchar(255) NOT NULL,
  Text_Answer varchar(255),
  Video_Answer  varchar(255),
  Image_Answer  varchar(255),
  Link_Answer varchar(255),
  Workflow_ID int,
  Presentation_Text varchar(255) NOT NULL,

  constraint pk_SubWorkflow primary key (SubWorkflow_ID),
  constraint fk_SubWorkflow_Workflow foreign key (Workflow_ID ) references Workflow  (Workflow_ID)
);

CREATE TABLE Answer (
  Answer_ID serial,
  Text_Answer varchar(255),
  Video_Answer  varchar(255),
  Image_Answer  varchar(255),
  Link_Answer varchar(255),
  SubWorkflow_ID int,
  Presentation_Text varchar(255),

  constraint pk_Answer primary key (Answer_ID),
  constraint fk_Answer_SubWorkflow foreign key (SubWorkflow_ID ) references SubWorkflow  (SubWorkflow_ID)
);

CREATE TABLE jobPosition (
   id serial,
   name varchar(100),
   
   constraint pk_jobPosition_id primary key(id)

);

CREATE TABLE jobs (
   id serial,
   name varchar(200), 
   jobDescription varchar(500), 
   jobCity varchar(50),
   jobState varchar(50),
   jobURL varchar(50),
   positionId int not null,
   
   constraint pk_jobs_id primary key(id)
   
);


CREATE TABLE users_jobPosition (
  user_id INTEGER  NOT NULL,
  jobPosition_id INTEGER NOT NULL,

  --PRIMARY KEY (venue_id, category_id)
  constraint fk_users_jobPosition_users foreign key (user_id) references users  (id),
  constraint fk_users_jobPosition_jobPosition foreign key (jobPosition_id) references jobPosition (id)
);

ALTER TABLE jobs
        ADD CONSTRAINT fk_position_id FOREIGN KEY (positionId) REFERENCES jobPosition (id)
        ON UPDATE CASCADE
        ON DELETE CASCADE;
        

COMMIT TRANSACTION;
