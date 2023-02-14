# Spring Advanced

## Material Review

### HTTP communication

- Retrofit
  - `Retrofit.Builder()`
  - `@GET`, `@POST`
  - `@Path`, `@Query`, `@Body`, `@Header`
  - `onFailure()`, `onSuccess()`

### Authentication

- Steps of authentication
  - register
  - login
  - client/server data
- Cookie
  - where is it stored?
  - who issues it?
  - who can read it?
  - what can be stored in it?
  - what's the format?
- Fluent pattern and Builder Pattern

### Authorization

- JWT Token
  - Symmetric key
  - Asymmetric key

### Spring Security

- `@EnableWebSecurity`
- `WebSecurityConfigurerAdapter`
- `antMatchers`
- `formLogin`
- `and`

### Testing and environments

- Environments
  - Test
  - Development
  - Production
- Mocking

## The apprentice should be able to

- Use Retrofit
- Mapping models with ModelMapper
- Create Test Environment
- Mocking with Mockito
- Authorizing with Google/Facebook/Twitter
- Authorize with JWT Token

## Workshop

The goal is to create an application, which communicates with a third-party API,
has token based authentication and configured test environment

### Write a back-end application

Write an application with basic endpoints that implements a REST API,
communicates with a third party API and stores the received data in a database.

#### Acceptance Criteria

- [Retrofit](https://square.github.io/retrofit/)
  is implemented in the application
- The application is communicating with the
  [The Movie Database API](https://developers.themoviedb.org/3/getting-started/introduction)
  or any other third-party API
- The application should connect to a SQL database
  and store the received data there
- The application should have an REST endpoint
  where the entries from the database are listed
- The database connection details should not be
  "hardcoded" into the application,
  it should be read from environment variables

### Create Token Authentication

Your Web API endpoints should be authorized with a valid JWT Token.
Use symmetric key to generate tokens with validation date.

#### Acceptance Criteria

- The application endpoints required to be authorized
- The application is validating the token from the request
- The application endpoints return `401` when the token is invalid or missing

### Test Environment

You are able to create the test environment
where you connect to an in-memory database.

#### Acceptance Criteria

- The application should connect to an in-memory database when the environment
  is set to `Test`
- The application should connect to a SQL database when the environment is set
  to `Production`

### Mocking

You are able to use a mocking framework to test services.

#### Acceptance Criteria

- The application has at least 3 tests where you use a mock object

### (Optional) Mapping

Separate the Entity Models from the ones you gave back in the response.
Create DTO models and use a mapper to conversion and vice-versa.

#### Acceptance Criteria

- The response should contain DTO models
- The service layer is converting the DTO models into entity models and
  vice-versa
