insert into admin_account (user_id, user_password, role_types, nickname, email, memo, created_at, created_by, modified_at, modified_by) values
('kss', '{noop}1234', 'ADMIN', 'Uno', 'uno@mail.com', 'I am Uno.', now(), 'uno', now(), 'uno'),
('kss2', '{noop}1234', 'MANAGER', 'Mark', 'mark@mail.com', 'I am Mark.', now(), 'uno', now(), 'uno'),
('kss3', '{noop}1234', 'MANAGER,DEVELOPER', 'Susan', 'Susan@mail.com', 'I am Susan.', now(), 'uno', now(), 'uno'),
('kss4', '{noop}1234', 'USER', 'Jim', 'jim@mail.com', 'I am Jim.', now(), 'uno', now(), 'uno')
;