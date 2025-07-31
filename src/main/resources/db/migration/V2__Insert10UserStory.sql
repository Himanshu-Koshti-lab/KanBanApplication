-- V2__insert_10_user_stories.sql

INSERT INTO user_story (id, title, description, status, creation_time, start_time, last_update, created_by, assigned_to) VALUES
(1, 'Login Page', 'Create login UI and backend API', 0, NOW(), null, null, 'Application Init', 'Current Developer'),
(2, 'Registration Page', 'Implement registration flow', 0, NOW(), null, null, 'Application Init', 'Current Developer'),
(3, 'User Dashboard', 'Design dashboard layout', 0, NOW(), null, null, 'Application Init', 'Current Developer'),
(4, 'Email Verification', 'Send verification email after signup', 0, NOW(), null, null, 'Application Init', 'Current Developer'),
(5, 'Password Reset', 'Allow users to reset their password', 0, NOW(), null, null, 'Application Init', 'Current Developer'),
(6, 'Profile Edit', 'Users can edit their profile details', 0, NOW(), null, null, 'Application Init', 'Current Developer'),
(7, 'Change Password', 'UI and API for password change', 0, NOW(), null, null, 'Application Init', 'Current Developer'),
(8, 'Upload Profile Picture', 'Add support for image uploads', 0, NOW(), null, null, 'Application Init', 'Current Developer'),
(9, 'Delete Account', 'Allow users to delete their account', 0, NOW(), null, null, 'Application Init', 'Current Developer'),
(10, 'Notification System', 'Send alerts for account activity', 0, NOW(), null, null, 'Application Init', 'Current Developer');
