/**
 * <p>Temporal annotation in Hibernate is used with the pojo properties of type java.util.Date and java.util.Calendar.</p>
 * <p>
 * <p>Temporal annotation automatically converts the date and time values from the Java object to the compatible database type.</p>
 * <p>
 * <p>
 * There are 3 types of temporal in the hibernate framework i.e.
 * <p>1. TemporalType.TIMESTAMP maps the date as java.sql.Timestamp</p>
 * <p>2. TemporalType.DATE maps the date as java.sql.Date</p>
 * <p>3. TemporalType.TIME maps the date as java.sql.Time</p>
 * <p>
 * <p>Since java 1.8 it is recommended to use java.time (as opposed to java.util.Date and java.util.Calendar)</p>
 *
 * @author Agnieszka Trzewik
 */
package ja.workshops.hibernate.parts.date_time_mapping;