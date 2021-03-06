
insert into positions (position_name, description) values
('SF', 'The small forward onsidered to be the most versatile of the main five basketball positions'),
('PF', 'The power forward often plays a role similar to that of the center'),
('C', 'The center,usually plays near the baseline or close to the basket'),
('SG', 'The shooting guard (SG) is also known as the two or the off guard'),
('PG','The point guard,typically the teams best ball handler and passer');

insert into teams (name, location) values
('Heat', 'Miami'),
('Lakers', 'LA'),
('Wizard', 'DC'),
('Bulls', 'Chicago'),
('Spurs','SanAntonio')
;

insert into players (name, first_name, last_name, weight, height, position_id,team_id) values
('LBJ', 'James', 'LeBorn', '112', '206', 1,2),
('Kobe', 'Kobe', 'Bryant', '96', '198', 4,2),
('Duncan', 'Duncan', 'Tim', '113', '211', 2,5),
('Ginobili', 'Ginobili', 'Manu', '93', '198', 5,5)
;



insert into roles (name, allowed_resource, allowed_read, allowed_create, allowed_update, allowed_delete) values
('Admin', '/', TRUE , TRUE, TRUE, TRUE),
('Manager', '/players,/users,/playerdata,/positions,/teams', TRUE, TRUE, TRUE, FALSE),
('user', '/players,/teams,/positions,/users,/playerdata', TRUE, FALSE, FALSE, FALSE)
;

insert into users (name, password, first_name, last_name, email) values
('hangec', '25f9e794323b453885f5181f1b624d0b', 'Hange', 'Chen', 'hangechen@training.ascendingdc.com'),
('rhang', '25f9e794323b453885f5181f1b624d0b', 'Ryo', 'Hang', 'rhang@training.ascendingdc.com'),
('xyhuang', '25f9e794323b453885f5181f1b624d0b', 'Xinyue', 'Huang', 'xyhuang@training.ascendingdc.com')
;

insert into users_roles values
(1, 1),
(2, 2),
(3, 3),
(1, 2),
(1, 3)
;
