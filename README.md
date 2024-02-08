# Liberty Enterprise Bean Client Servlet

An example servlet to invoke a remote enterprise bean from Liberty.

## How to use

- Edit `src/main/java/example/Servlet.java` 
  - Change the host, port, and lookup name to match the required remote enterprise bean
- Build the project using `./gradlew build`
- Create a Liberty server by running `server create exampleServer`, replacing the config with the `server.xml` from this repo
- Copy the built WAR file (`build/libs/liberty-enterprise-bean-client-servlet.war`) into the newly created server's `dropins` folder
- Start the server using `server run exampleServer`
- Navigate to http://localhost:19080/liberty-enterbrise-bean-client-servlet/servlet
  - The output should look like something like this: `org.apache.yoko.orb.CORBA.StubForRemote:org.apache.yoko.orb.CORBA.Delegate@d0a511cc`
  - This shows successful contact with the remote system
  - The object is a vanilla stub and can't do much yet

## Next steps

The code must be edited to narrow the stub to a particular interface.
This will require the enterprise bean interface to be made available to the servlet, at compile time _and_ at run time.
After narrowing, the stub may be invoked using the methods on the interface.

If the remote enterprise bean has application security enabled, additional configuration will be required to allow the Liberty server to connect to the remote enterprise bean host.