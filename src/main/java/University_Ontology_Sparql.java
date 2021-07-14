import org.apache.jena.rdfconnection.RDFConnection;
import org.apache.jena.rdfconnection.RDFConnectionFactory;
import org.apache.jena.query.*;

public class University_Ontology_Sparql {
    public static void main(String ...args) {

        Dataset dataset = DatasetFactory.createTxnMem();
        RDFConnection conn = RDFConnectionFactory.connect(dataset);
        conn.load("http://localhost:3030/university.ttl") ;
        QueryExecution query1 = conn.query("PREFIX ns:<http://www.semanticweb.org/abc/ontologies/2020/11/untitled-ontology-16#> \n" +
                "PREFIX rdfs:<http://www.w3.org/2000/01/rdf-schema#>"+
                "PREFIX rdf:<http://www.w3.org/1999/02/22-rdf-syntax-ns#>"+
                "SELECT Distinct ?Student ?studentID ?department ?age  WHERE{ \n" +

                "VALUES ?b {ns:OWLClass_fd2999a3_c1b6_4aa8_b477_16c7587048e2dsafasdf} ?book a ?b ."+
                "?Student ns:OWLDataProperty_11c54f26_6937_4b6c_87ef_f7273d0d85fadsafasdf ?studentID ."+
                "?Student ns:OWLDataProperty_b15d3cdc_b1a5_4366_b1f5_7c621e91a7bbdsafasdf ?department ."+
                "?Student ns:OWLDataProperty_7e8ec649_6956_4799_aafb_c3700c4ab25cdsafasdf ?age ."+

                "}") ;
        ResultSet rs1 = query1.execSelect() ;
        while(rs1.hasNext()) {
            Query query=QueryFactory.create(query1.getQuery());
            ResultSetFormatter.out(System.out, rs1, query);
        }
        query1.close() ;
        conn.close() ;


        RDFConnection conn2 = RDFConnectionFactory.connect(dataset);
        conn2.load("http://localhost:3030/university.ttl") ;

        QueryExecution query2 = conn2.query("PREFIX ns:<http://www.semanticweb.org/abc/ontologies/2020/11/untitled-ontology-16#> \n" +
                "PREFIX rdfs:<http://www.w3.org/2000/01/rdf-schema#>"+
                "PREFIX rdf:<http://www.w3.org/1999/02/22-rdf-syntax-ns#>"+
                "SELECT  Distinct ?professorID ?adress WHERE{ \n" +
                "?professor a ?p.  FILTER (?p IN (ns:OWLClass_ea8bd2ec_7bbd_4764_9199_3d7fdf660c6edsafasdf) ) "+

                "?professor ns:OWLDataProperty_57eb3474_d485_4f92_a94d_ca11c4f822e8dsafasdf ?professorID ."+

                "?professor ns:OWLDataProperty_bad98bb7_c6cd_4667_92e6_3d4bfa2007a9dsafasdf ?adress ."+

                "}") ;
        ResultSet rs2 = query2.execSelect() ;
        while(rs2.hasNext()) {
            Query queryy=QueryFactory.create(query2.getQuery());
            ResultSetFormatter.out(System.out, rs2, queryy);

        }
        query2.close() ;
        conn2.close() ;

        RDFConnection conn3 = RDFConnectionFactory.connect(dataset);
        conn3.load("http://localhost:3030/university.ttl") ;

        QueryExecution query3 = conn3.query("PREFIX ns:<http://www.semanticweb.org/abc/ontologies/2020/11/untitled-ontology-16#> \n" +
                "PREFIX rdfs:<http://www.w3.org/2000/01/rdf-schema#>"+
                "PREFIX rdf:<http://www.w3.org/1999/02/22-rdf-syntax-ns#>"+
                "SELECT  Distinct ?studentID ?phoneNumber ?adress WHERE{ \n" +
                "?student a ?p.  FILTER (?p IN (ns:OWLClass_fd2999a3_c1b6_4aa8_b477_16c7587048e2dsafasdf) ) "+

                "?student ns:OWLDataProperty_11c54f26_6937_4b6c_87ef_f7273d0d85fadsafasdf ?studentID ."+

                "?student ns:OWLDataProperty_bad98bb7_c6cd_4667_92e6_3d4bfa2007a9dsafasdf ?adress ."+

                "?student ns:OWLDataProperty_d9f283d3_4a63_4607_a18c_1869db352affdsafasdf ?phoneNumber ."+

                "}") ;
        ResultSet rs3 = query3.execSelect() ;
        while(rs3.hasNext()) {
            Query queryyy=QueryFactory.create(query3.getQuery());
            ResultSetFormatter.out(System.out, rs3, queryyy);

        }
        query3.close() ;
        conn3.close() ;
    }
}
