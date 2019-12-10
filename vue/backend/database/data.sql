-- Password for this user is 'greatwall'
INSERT INTO users ("username", "password", "salt", "role") VALUES
('user',
'FjZDm+sndmsdEDwNtfr6NA==',
'kidcasB0te7i0jK0fmRIGHSm0mYhdLTaiGkEAiEvLp7dAEHWnuT8n/5bd2V/mqjstQ198iImm1xCmEFu+BHyOz1Mf7vm4LILcrr17y7Ws40Xyx4FOCt8jD03G+jEafpuVJnPiDmaZQXJEpEfekGOvhKGOCtBnT5uatjKEuVWuDA=',
'user');

-- Category data
INSERT INTO Category (Name) VALUES ('Pathyway');
INSERT INTO Category (Name) VALUES ('Curriculum');
INSERT INTO Category (Name) VALUES ('Job Search');

-- WorkFlow data
INSERT INTO Workflow (Name,Category_ID) VALUES ('I need help with',1);
INSERT INTO Workflow (Name,Category_ID) VALUES ('Where can I learn about',1);
INSERT INTO Workflow (Name,Category_ID) VALUES ('I do not understand',1);
INSERT INTO Workflow (Name,Category_ID) VALUES ('What is',1);

--SubWorkFlow data
INSERT INTO SubWorkflow (Name, Text_Answer, Workflow_ID) VALUES ('Writing a cover letter', 'provide your eleavtor pitch here, to get the best impression',1);
INSERT INTO SubWorkflow (Name, Text_Answer, Workflow_ID) VALUES ('Prepping for an interview', 'Be on time', 1);
INSERT INTO SubWorkflow (Name, Text_Answer, Workflow_ID) VALUES ('Following up with employers','send an email', 1);
INSERT INTO SubWorkflow (Name, Text_Answer, Workflow_ID) VALUES ('What to wear to an interview','wear busines casual', 1);



