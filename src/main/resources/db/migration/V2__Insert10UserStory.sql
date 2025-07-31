-- V2__insert_10_user_stories.sql

INSERT INTO user_story (id, title, description, status, creation_time, start_time, last_update) VALUES
(1, 'Login Page', 'Create login UI and backend API', 0, NOW(), null, null),
(2, 'Registration Page', 'Implement registration flow', 0, NOW(), null, null),
(3, 'User Dashboard', 'Design dashboard layout', 0, NOW(), null, null),
(4, 'Email Verification', 'Send verification email after signup', 0, NOW(), null, null),
(5, 'Password Reset', 'Allow users to reset their password', 0, NOW(), null, null),
(6, 'Profile Edit', 'Users can edit their profile details', 0, NOW(), null, null),
(7, 'Change Password', 'UI and API for password change', 0, NOW(), null, null),
(8, 'Upload Profile Picture', 'Add support for image uploads', 0, NOW(), null, null),
(9, 'Delete Account', 'Allow users to delete their account', 0, NOW(), null, null),
(10, 'Notification System', 'Send alerts for account activity', 0, NOW(), null, null);
