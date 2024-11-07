CREATE TABLE IF NOT EXISTS rooms (
    room_id SERIAL PRIMARY KEY,
    room_name VARCHAR(255) NOT NULL
);


CREATE TABLE IF NOT EXISTS projects (
    project_id SERIAL PRIMARY KEY,
    project_name VARCHAR(255) NOT NULL,
    project_status VARCHAR(50),
    project_estimated_cost DECIMAL(10,2),
    project_start_date DATE,
    project_completion_date DATE,
    project_created_at TIMESTAMP,
    project_room INTEGER,
    foreign key (project_room) references rooms(room_id) 
);

create table if not exists tasks (
	task_id SERIAL primary key,
	task_name VARCHAR(255) not null,
	task_notes VARCHAR(500),
	task_due_date DATE,
	task_priority VARCHAR(50),
	task_est_time FLOAT(2),
	task_person VARCHAR(50),
	task_project INTEGER,
	foreign key (task_project) references projects(project_id)	
);

Create table if not EXISTS materials (
    material_id SERIAL PRIMARY KEY,
    material_name VARCHAR(255) NOT NULL,
    material_cost NUMERIC,
    material_procured BOOLEAN,
    material_project INTEGER,
    FOREIGN KEY materials(material_project) REFERENCES projects(project_id)
);