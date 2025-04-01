--Initial Users (4 rows)
SELECT * FROM appcon.subscribers;

--Initial Roles (3 rows)
SELECT * FROM appcon.roles;

--Initial Subscriber Roles Association (9 rows)
SELECT * FROM appcon.subscriber_roles 
	INNER JOIN appcon.subscribers ON subscribers.subscriber_id = subscriber_roles.subscriber_id
	INNER JOIN appcon.roles ON roles.role_id = subscriber_roles.role_id;

--Initial Subscriber Invitations (9 rows)
SELECT * FROM appcon.invitations 
	INNER JOIN appcon.subscribers ON subscribers.subscriber_id = invitations.subscriber_id
	INNER JOIN appcon.roles ON roles.role_id = invitations.role_id;
