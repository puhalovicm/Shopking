using System.Web;
using FluentNHibernate.Cfg;
using FluentNHibernate.Cfg.Db;
using NHibernate;
using NHibernate.Cfg;
using Shopking.Models;

namespace Shopking
{
    public class NHibernateSession
    {
        public static ISession OpenSession()
        {
            var nhConfig = Fluently
                .Configure()
                .Database(PostgreSQLConfiguration.Standard.ConnectionString("User ID=username;Password=password;Host=localhost;Port=5432;Database=shopkingdb").AdoNetBatchSize(100))
                .Mappings(mappings => mappings.FluentMappings.AddFromAssemblyOf<Shop>())
                .BuildConfiguration();

            var sessionFactory = nhConfig.BuildSessionFactory();
            ISession sess = sessionFactory.OpenSession();
            //var schemaExport = new SchemaExport(nhConfig);
            //schemaExport.Create(false, true);
            return sess;
        }
    }
}
