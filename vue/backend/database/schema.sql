BEGIN TRANSACTION;

DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS Category;
DROP TABLE IF EXISTS Workflow;
DROP TABLE IF EXISTS Subworkflow;

CREATE TABLE users (
  id serial PRIMARY KEY,
  username varchar(255) NOT NULL UNIQUE,     -- Username
  password varchar(32) NOT NULL,      -- Password
  salt varchar(256) NOT NULL,          -- Password Salt
  role varchar(255) NOT NULL default('user')
);

CREATE TABLE Category (
  Category_ID serial,
  Name varchar(255) NOT NULL UNIQUE,

  constraint pk_Category primary key (Category_ID)
);

CREATE TABLE Workflow (
  Workflow_ID serial,
  Name varchar(255) NOT NULL UNIQUE,
  Category_ID int,

  constraint pk_Workflow primary key (Workflow_ID),
  constraint fk_Workflow_Category foreign key (Category_ID) references Category  (Category_ID)
);

CREATE TABLE SubWorkflow (
  SubWorkflow_ID serial,
  Name varchar(255) NOT NULL UNIQUE,
  Text_Answer varchar(255),
  Video_Answer  varchar(255),
  Image_Answer  varchar(255),
  Link_Answer varchar(255),
  Workflow_ID int,

  constraint pk_SubWorkflow primary key (SubWorkflow_ID),
  constraint fk_SubWorkflow_Workflow foreign key (Workflow_ID ) references Workflow  (Workflow_ID)
);

COMMIT TRANSACTION;
