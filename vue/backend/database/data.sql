-- Password for this user is 'greatwall'
INSERT INTO users ("username", "password", "salt", "role","firstname","lastname","avatar") VALUES
('user',
'FjZDm+sndmsdEDwNtfr6NA==',
'kidcasB0te7i0jK0fmRIGHSm0mYhdLTaiGkEAiEvLp7dAEHWnuT8n/5bd2V/mqjstQ198iImm1xCmEFu+BHyOz1Mf7vm4LILcrr17y7Ws40Xyx4FOCt8jD03G+jEafpuVJnPiDmaZQXJEpEfekGOvhKGOCtBnT5uatjKEuVWuDA=',
'user', 'doe', 'smith', 'test.img');


-- Category data
INSERT INTO Category (Name,Presentation_Text) VALUES ('Pathway','Select one of the options below');
INSERT INTO Category (Name,Presentation_Text) VALUES ('Curriculum','Select one of the options below');
INSERT INTO Category (Name,Presentation_Text) VALUES ('Job Search','Select one of the options below');

-- WorkFlow data
INSERT INTO Workflow (Name,Presentation_Text,Category_ID) VALUES ('I need help with','These are the things I can help with for pathway',1);
INSERT INTO Workflow (Name,Presentation_Text,Category_ID) VALUES ('Where can I learn about','These are the things I can help with for pathway',1);
INSERT INTO Workflow (Name,Presentation_Text,Category_ID) VALUES ('I do not understand','These are the things I can help with for pathway',1);
INSERT INTO Workflow (Name,Presentation_Text,Category_ID) VALUES ('What is','These are the things I can help with for pathway',1);
--curriculum WorkFlow 
INSERT INTO Workflow (Name,Presentation_Text,Category_ID) VALUES ('I need help with','These are the things I can help with for curriculum',2);
INSERT INTO Workflow (Name,Presentation_Text,Category_ID) VALUES ('Where can I learn about', 'These are the things I can help with for curriculum',2);
INSERT INTO Workflow (Name,Presentation_Text,Category_ID) VALUES ('I do not understand','These are the things I can help with for curriculum',2);
INSERT INTO Workflow (Name,Presentation_Text,Category_ID) VALUES ('What is','These are the things I can help with for curriculum',2);

--SubWorkFlow data
INSERT INTO SubWorkflow (Name, Text_Answer, Video_Answer, Link_Answer, Workflow_ID, Presentation_Text) VALUES ('Writing a cover letter', 'Below help is available.', 'https://www.youtube.com/watch?v=se-klYpUI08' , 'https://resumegenius.com/cover-letter-examples/college-student-cover-letter-sample', 1, '1. Introduce yourself.
2. Mention the job (or kind of job) you are applying for (or looking for)');
INSERT INTO SubWorkflow (Name, Text_Answer,Presentation_Text, Workflow_ID) VALUES ('Prepping for an interview', 'Be on time','Below help is available',1);
INSERT INTO SubWorkflow (Name, Text_Answer,Presentation_Text, Workflow_ID) VALUES ('Following up with employers','send an email','Below help is available',1);
INSERT INTO SubWorkflow (Name, Text_Answer, Presentation_Text,Workflow_ID) VALUES ('What to wear to an interview','wear busines casual','Below help is available',1);
--curriculum SubWorkFlow 
INSERT INTO SubWorkflow (Name, Text_Answer,Presentation_Text, Workflow_ID) VALUES ('Creating a new project', 'create your POM.xml','Below help is available',5);
INSERT INTO SubWorkflow (Name, Text_Answer,Presentation_Text, Workflow_ID) VALUES ('Arrays', 'An array is collection of items stored at contiguous memory locations','Below help is available',5);
INSERT INTO SubWorkflow (Name, Text_Answer,Presentation_Text, Workflow_ID) VALUES ('MVC','MVC stands for Model, View and Controller','Below help is available',5);
INSERT INTO SubWorkflow (Name, Text_Answer, Presentation_Text,Workflow_ID) VALUES ('SQL','SQL (pronounced "ess-que-el") stands for Structured Query Language','Below help is available',5);
--Answer data
INSERT INTO Answer ( Text_Answer, SubWorkflow_ID) VALUES ('provide your eleavtor pitch here, to get the best impression',1);
INSERT INTO Answer (Text_Answer, SubWorkflow_ID) VALUES ( 'Be on time',2);
INSERT INTO Answer (Text_Answer, SubWorkflow_ID) VALUES ('send an email',3);
INSERT INTO Answer (Text_Answer,SubWorkflow_ID) VALUES ('wear busines casual',4);
--curriculum Answer
INSERT INTO Answer ( Text_Answer, SubWorkflow_ID) VALUES ('create your POM.xml',5);
INSERT INTO Answer (Text_Answer, SubWorkflow_ID) VALUES ( 'An array is collection of items stored at contiguous memory locations',6);
INSERT INTO Answer (Text_Answer, SubWorkflow_ID) VALUES ('MVC stands for Model, View and Controller',7);
INSERT INTO Answer (Text_Answer,SubWorkflow_ID) VALUES ('SQL (pronounced "ess-que-el") stands for Structured Query Language',8);


--JobPosition data

INSERT INTO jobPosition(name)
VALUES('Software Engineer');

INSERT INTO jobPosition(name)
VALUES('Database Administrator');

INSERT INTO jobPosition(name)
VALUES('Data Analyst');

--Jobs data

INSERT INTO jobs(name, jobDescription, jobCity, jobState, jobURL, positionId)
VALUES('Software Engineer (Jr-Mid)', 'As a Software Engineer, you will be working on an 
Agile team for our Private Aviation Client here in Columbus, OH. As the Software Support 
Engineer, you will be on a team that is involved in a project focusing on the #1 initiative 
in the company, which involves maintaining, enhancing, and supporting the Human Resources 
data in a cloud-based software.', 'Columbus', 'OH', 'https://g.co/kgs/X3y1nT', 1);

INSERT INTO jobs(name, jobDescription, jobCity, jobState, jobURL, positionId)
VALUES('JUNIOR Javascript Developer with Cloud', 'Junior Level Javascript Developer with 
cloud experience. New College graduate ok or 1-2 years of experience.', 'Columbus', 'OH', 'https://g.co/kgs/Kzr9UV', 1); 

INSERT INTO jobs(name, jobDescription, jobCity, jobState, jobURL, positionId)
VALUES('Junior Web Developer', 'CFS Technology, Central Ohios premier IT staffing solutions 
provider, has been contacted by a longtime client that is currently seeking a Junior Web Developer 
with experience working with ASP.NET and C#.', 'Columbus', 'OH', 'https://g.co/kgs/N7PTGq', 1);

INSERT INTO jobs(name, jobDescription, jobCity, jobState, jobURL, positionId)
VALUES('Software Engineer - C#', 'Infoscitex (IST), a DCS company, has an outstanding opportunity 
for a Software Engineer to develop and test C# code. This is an opportunity to join a growing, 
cutting-edge team in creating next-generation autonomy technologies for the Department of Defense.', 
 'Dayton', 'OH', 'https://g.co/kgs/dqPxnt', 1);

INSERT INTO jobs(name, jobDescription, jobCity, jobState, jobURL, positionId)
VALUES('Software Engineer - Database Architecture', 'The Software Engineer is responsible for the 
development, implementation, maintenance, and support of software solutions. Associates in this 
position must be experienced in advanced programming, design patterns, and databases. This job 
requires a key hands-on contributor in the software development life-cycle, performing analysis and 
design as well as influencing development teams to achieve project goals. ', 
 'Richmond', 'VA', 'https://g.co/kgs/LEin4y', 2);

INSERT INTO jobs(name, jobDescription, jobCity, jobState, jobURL, positionId)
VALUES('Database Administrator (DBA)', 'Database Administrator (DBA). The Database Administrator 
(DBA) in this contract or contract-to-hire opening in Columbus, Ohio will assist in database systems 
projects and facilitate development efforts from the application teams ...', 'Columbus', 'OH', 'https://g.co/kgs/tFR5gE', 2);

INSERT INTO jobs(name, jobDescription, jobCity, jobState, jobURL, positionId)
VALUES('Database Administrator', 'GDIT is seeking a Database Administrator who will be responsible for designing, planning, 
implementing, and administering databases, including security, access, and documentation.', 'Fort Belvoir', 'VA', 'https://g.co/kgs/C66Gjn', 2);

INSERT INTO jobs(name, jobDescription, jobCity, jobState, jobURL, positionId)
VALUES('Data Analyst', 'Our client is looking for an International Trade Management Analyst. Facilitate communication 
between the client, Third-party service provider and Customs brokers.', 'Columbus', 'OH', 'https://g.co/kgs/N2bFHL', 3);

INSERT INTO jobs(name, jobDescription, jobCity, jobState, jobURL, positionId)
VALUES('IS Data Center Analyst II', 'We are seeking an IS Data Center Analyst II - The IS Data Center Analyst II is 
responsible for day-to-day administration and availability of systems and applications that reside in the data centers. 
This position will monitor, document and trend daily events in the data centers with the emphasis on system availability.',
 'Columbus', 'OH', 'https://g.co/kgs/N12tmV', 3);

INSERT INTO jobs(name, jobDescription, jobCity, jobState, jobURL, positionId)
VALUES('Data Analyst - 55969', 'If you are looking for a career that will provide a challenging work environment and many 
opportunities to learn, our company is the place for you. Join our team and become part of a company full of exciting 
opportunities. We help employees achieve their personal best by offering many opportunities that develop and enhance their 
skills for career advancement.', 'Dublin', 'OH', 'https://g.co/kgs/ZB6at1', 3);


-- User_JobPosition data
INSERT INTO users_jobPosition(user_id, jobPosition_id) Values(1,1);
INSERT INTO users_jobPosition(user_id, jobPosition_id) Values(1,2);



