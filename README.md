## Adwise

Adwise is an application for various types of advertisements, catering to everyone's needs.

### Components

1. **CustomNavbar**
   - ![image](https://github.com/kubas8111/ZTPAI/assets/80070461/34e7f9f1-9611-4331-9ac6-79a652c379c5)
   - Description: The navigation bar component for the application.
   
2. **LoginPanel**
   - ![image](https://github.com/kubas8111/ZTPAI/assets/80070461/1d944f73-b41e-4be2-a471-88568a3a697a)
   - Description: Component for user login functionality.
   
3. **Item**
   - ![image](https://github.com/kubas8111/ZTPAI/assets/80070461/c886c1f2-c002-4b4f-a93c-8c7dad5dc974)
   - Description: Component representing an item in the application.
   
4. **Comment**
   - ![image](https://github.com/kubas8111/ZTPAI/assets/80070461/7f524af0-43a1-430e-9b0f-00df88c3d04d)
   - Description: Component for adding comments to items.

### Features

- **Authentication**: User login and registration functionality.
- **Announcement Management**: Users can add, edit, and delete announcements.
- **Commenting**: Users can add comments to items.
- **User Profiles**: Each user has a profile page with their announcements and comments.
- **Role-based Access Control**: Admins have additional privileges such as deleting announcements.
  
### Technologies

- **Frontend**: React
- **Backend**: Spring Boot
- **Database**: H2 (embedded with Spring Boot)
- **File Storage**: Local storage for image files.

## How to Run

1. Clone the repository: `git clone <repository-url>`
2. Navigate to the project directory: `cd <project-directory>`
3. Install dependencies: `npm install`
4. Start the frontend: `npm start`
5. Open the browser and visit `http://localhost:3000` to view the application.

## Configuration

- **Backend Configuration**: Update `application.properties` file in the Spring Boot project for database configurations.
- **Frontend Configuration**: Modify environment variables or configuration files in the React project for API endpoints and other settings.
