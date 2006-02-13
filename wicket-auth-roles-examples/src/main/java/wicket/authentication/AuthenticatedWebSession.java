package wicket.authentication;

import wicket.Session;
import wicket.authorization.strategies.role.Roles;
import wicket.protocol.http.WebApplication;
import wicket.protocol.http.WebSession;

/**
 * Basic authenticated web session.
 * 
 * @author Jonathan Locke
 */
public abstract class AuthenticatedWebSession extends WebSession
{
	/**
	 * @return Current authenticated web session
	 */
	public static AuthenticatedWebSession get()
	{
		return (AuthenticatedWebSession)Session.get();
	}

	/**
	 * Construct.
	 * 
	 * @param application
	 *            The web application
	 */
	protected AuthenticatedWebSession(WebApplication application)
	{
		super(application);
	}

	/**
	 * @return Get the roles that this session can play
	 */
	public abstract Roles getRoles();
}
