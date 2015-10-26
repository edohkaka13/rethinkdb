// Autogenerated by convert_tests.py and process_polyglot.py.
// Do not edit this file directly.
// The template for this file is located at:
// ../../../../../templates/Test.java
package gen;

import com.rethinkdb.RethinkDB;
import com.rethinkdb.gen.exc.*;
import com.rethinkdb.gen.ast.*;
import com.rethinkdb.ast.ReqlAst;
import com.rethinkdb.model.MapObject;
import com.rethinkdb.model.OptArgs;
import com.rethinkdb.net.Connection;
import com.rethinkdb.net.Cursor;
import junit.framework.TestCase;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertArrayEquals;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.junit.*;
import org.junit.rules.ExpectedException;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.Instant;
import java.util.stream.LongStream;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.concurrent.TimeoutException;
import java.util.regex.Pattern;
import java.util.Collections;
import java.nio.charset.StandardCharsets;

import static gen.TestingCommon.*;
import gen.TestingFramework;

public class Match {
    // Tests for match
    Logger logger = LoggerFactory.getLogger(Match.class);
    public static final RethinkDB r = RethinkDB.r;
    public static final Table tbl = r.db("test").table("tbl");

    Connection<?> conn;
    public String hostname = TestingFramework.getConfig().getHostName();
    public int port = TestingFramework.getConfig().getPort();

    @Before
    public void setUp() throws Exception {
        logger.info("Setting up.");
        conn = TestingFramework.createConnection();
        try {
            r.dbCreate("test").run(conn);
            r.db("test").wait_().run(conn);
        }catch (Exception e){}
        try {
            r.db("test").tableCreate("tbl").run(conn);
            r.db("test").table(tbl).wait_().run(conn);
        }catch (Exception e){}
    }

    @After
    public void tearDown() throws Exception {
        logger.info("Tearing down.");
        r.db("rethinkdb").table("_debug_scratch").delete().run(conn);
        if(!conn.isOpen()){
            conn.close();
            conn = TestingFramework.createConnection();
        }
        r.db("test").tableDrop("tbl").run(conn);
        r.dbDrop("test").run(conn);
        conn.close(false);
    }

    // Autogenerated tests below

        @Test(timeout=120000)
    public void test() throws Exception {
                
        {
            // match.yaml line #4
            /* ({'str':'bcde','groups':[null,{'start':2,'str':'cde','end':5}],'start':1,'end':5}) */
            Map expected_ = r.hashMap("str", "bcde").with("groups", r.array(null, r.hashMap("start", 2L).with("str", "cde").with("end", 5L))).with("start", 1L).with("end", 5L);
            /* r.expr("abcdefg").match("a(b.e)|b(c.e)") */
            logger.info("About to run line #4: r.expr('abcdefg').match('a(b.e)|b(c.e)')");
            Object obtained = runOrCatch(r.expr("abcdefg").match("a(b.e)|b(c.e)"),
                                          new OptArgs()
                                          ,conn);
            try {
                assertEquals(expected_, obtained);
            logger.info("Finished running line #4");
            } catch (Throwable ae) {
                logger.error("Whoops, got exception on line #4:" + ae.toString());
                if(obtained instanceof Throwable) {
                    ae.addSuppressed((Throwable) obtained);
                }
                throw ae;
            }
        }
        
        {
            // match.yaml line #6
            /* (null) */
            Object expected_ = null;
            /* r.expr("abcdefg").match("a(b.e)|B(c.e)") */
            logger.info("About to run line #6: r.expr('abcdefg').match('a(b.e)|B(c.e)')");
            Object obtained = runOrCatch(r.expr("abcdefg").match("a(b.e)|B(c.e)"),
                                          new OptArgs()
                                          ,conn);
            try {
                assertEquals(expected_, obtained);
            logger.info("Finished running line #6");
            } catch (Throwable ae) {
                logger.error("Whoops, got exception on line #6:" + ae.toString());
                if(obtained instanceof Throwable) {
                    ae.addSuppressed((Throwable) obtained);
                }
                throw ae;
            }
        }
        
        {
            // match.yaml line #8
            /* ({'str':'bcde','groups':[null,{'start':2,'str':'cde','end':5}],'start':1,'end':5}) */
            Map expected_ = r.hashMap("str", "bcde").with("groups", r.array(null, r.hashMap("start", 2L).with("str", "cde").with("end", 5L))).with("start", 1L).with("end", 5L);
            /* r.expr("abcdefg").match("(?i)a(b.e)|B(c.e)") */
            logger.info("About to run line #8: r.expr('abcdefg').match('(?i)a(b.e)|B(c.e)')");
            Object obtained = runOrCatch(r.expr("abcdefg").match("(?i)a(b.e)|B(c.e)"),
                                          new OptArgs()
                                          ,conn);
            try {
                assertEquals(expected_, obtained);
            logger.info("Finished running line #8");
            } catch (Throwable ae) {
                logger.error("Whoops, got exception on line #8:" + ae.toString());
                if(obtained instanceof Throwable) {
                    ae.addSuppressed((Throwable) obtained);
                }
                throw ae;
            }
        }
        
        {
            // match.yaml line #12
            /* (["aca", "ada"]) */
            List expected_ = r.array("aca", "ada");
            /* r.expr(["aba", "aca", "ada", "aea"]).filter(lambda row:row.match("a(.)a")['groups'][0]['str'].match("[cd]")) */
            logger.info("About to run line #12: r.expr(r.array('aba', 'aca', 'ada', 'aea')).filter(row -> row.match('a(.)a').bracket('groups').bracket(0L).bracket('str').match('[cd]'))");
            Object obtained = runOrCatch(r.expr(r.array("aba", "aca", "ada", "aea")).filter(row -> row.match("a(.)a").bracket("groups").bracket(0L).bracket("str").match("[cd]")),
                                          new OptArgs()
                                          ,conn);
            try {
                assertEquals(expected_, obtained);
            logger.info("Finished running line #12");
            } catch (Throwable ae) {
                logger.error("Whoops, got exception on line #12:" + ae.toString());
                if(obtained instanceof Throwable) {
                    ae.addSuppressed((Throwable) obtained);
                }
                throw ae;
            }
        }
        
        {
            // match.yaml line #16
            /* ({'deleted':0,'replaced':0,'unchanged':0,'errors':0,'skipped':0,'inserted':3}) */
            Map expected_ = r.hashMap("deleted", 0L).with("replaced", 0L).with("unchanged", 0L).with("errors", 0L).with("skipped", 0L).with("inserted", 3L);
            /* tbl.insert([{'id':0,'a':'abc'},{'id':1,'a':'ab'},{'id':2,'a':'bc'}]) */
            logger.info("About to run line #16: tbl.insert(r.array(r.hashMap('id', 0L).with('a', 'abc'), r.hashMap('id', 1L).with('a', 'ab'), r.hashMap('id', 2L).with('a', 'bc')))");
            Object obtained = runOrCatch(tbl.insert(r.array(r.hashMap("id", 0L).with("a", "abc"), r.hashMap("id", 1L).with("a", "ab"), r.hashMap("id", 2L).with("a", "bc"))),
                                          new OptArgs()
                                          ,conn);
            try {
                assertEquals(expected_, obtained);
            logger.info("Finished running line #16");
            } catch (Throwable ae) {
                logger.error("Whoops, got exception on line #16:" + ae.toString());
                if(obtained instanceof Throwable) {
                    ae.addSuppressed((Throwable) obtained);
                }
                throw ae;
            }
        }
        
        {
            // match.yaml line #20
            /* ([{'id':0,'a':'abc'},{'id':1,'a':'ab'},{'id':2,'a':'bc'}]) */
            List expected_ = r.array(r.hashMap("id", 0L).with("a", "abc"), r.hashMap("id", 1L).with("a", "ab"), r.hashMap("id", 2L).with("a", "bc"));
            /* tbl.filter(lambda row:row['a'].match('b')).order_by('id') */
            logger.info("About to run line #20: tbl.filter(row -> row.bracket('a').match('b')).orderBy('id')");
            Object obtained = runOrCatch(tbl.filter(row -> row.bracket("a").match("b")).orderBy("id"),
                                          new OptArgs()
                                          ,conn);
            try {
                assertEquals(expected_, obtained);
            logger.info("Finished running line #20");
            } catch (Throwable ae) {
                logger.error("Whoops, got exception on line #20:" + ae.toString());
                if(obtained instanceof Throwable) {
                    ae.addSuppressed((Throwable) obtained);
                }
                throw ae;
            }
        }
        
        {
            // match.yaml line #24
            /* ([{'id':0,'a':'abc'},{'id':1,'a':'ab'}]) */
            List expected_ = r.array(r.hashMap("id", 0L).with("a", "abc"), r.hashMap("id", 1L).with("a", "ab"));
            /* tbl.filter(lambda row:row['a'].match('ab')).order_by('id') */
            logger.info("About to run line #24: tbl.filter(row -> row.bracket('a').match('ab')).orderBy('id')");
            Object obtained = runOrCatch(tbl.filter(row -> row.bracket("a").match("ab")).orderBy("id"),
                                          new OptArgs()
                                          ,conn);
            try {
                assertEquals(expected_, obtained);
            logger.info("Finished running line #24");
            } catch (Throwable ae) {
                logger.error("Whoops, got exception on line #24:" + ae.toString());
                if(obtained instanceof Throwable) {
                    ae.addSuppressed((Throwable) obtained);
                }
                throw ae;
            }
        }
        
        {
            // match.yaml line #28
            /* ([{'id':1,'a':'ab'}]) */
            List expected_ = r.array(r.hashMap("id", 1L).with("a", "ab"));
            /* tbl.filter(lambda row:row['a'].match('ab$')).order_by('id') */
            logger.info("About to run line #28: tbl.filter(row -> row.bracket('a').match('ab$')).orderBy('id')");
            Object obtained = runOrCatch(tbl.filter(row -> row.bracket("a").match("ab$")).orderBy("id"),
                                          new OptArgs()
                                          ,conn);
            try {
                assertEquals(expected_, obtained);
            logger.info("Finished running line #28");
            } catch (Throwable ae) {
                logger.error("Whoops, got exception on line #28:" + ae.toString());
                if(obtained instanceof Throwable) {
                    ae.addSuppressed((Throwable) obtained);
                }
                throw ae;
            }
        }
        
        {
            // match.yaml line #32
            /* ([]) */
            List expected_ = r.array();
            /* tbl.filter(lambda row:row['a'].match('^b$')).order_by('id') */
            logger.info("About to run line #32: tbl.filter(row -> row.bracket('a').match('^b$')).orderBy('id')");
            Object obtained = runOrCatch(tbl.filter(row -> row.bracket("a").match("^b$")).orderBy("id"),
                                          new OptArgs()
                                          ,conn);
            try {
                assertEquals(expected_, obtained);
            logger.info("Finished running line #32");
            } catch (Throwable ae) {
                logger.error("Whoops, got exception on line #32:" + ae.toString());
                if(obtained instanceof Throwable) {
                    ae.addSuppressed((Throwable) obtained);
                }
                throw ae;
            }
        }
        
        {
            // match.yaml line #36
            /* err("ReqlQueryLogicError", "Error in regexp `ab\\9` (portion `\\9`): invalid escape sequence: \\9", []) */
            Err expected_ = err("ReqlQueryLogicError", "Error in regexp `ab\\9` (portion `\\9`): invalid escape sequence: \\9", r.array());
            /* r.expr("").match("ab\\9") */
            logger.info("About to run line #36: r.expr('').match('ab\\\\9')");
            Object obtained = runOrCatch(r.expr("").match("ab\\9"),
                                          new OptArgs()
                                          ,conn);
            try {
                assertEquals(expected_, obtained);
            logger.info("Finished running line #36");
            } catch (Throwable ae) {
                logger.error("Whoops, got exception on line #36:" + ae.toString());
                if(obtained instanceof Throwable) {
                    ae.addSuppressed((Throwable) obtained);
                }
                throw ae;
            }
        }
    }
}
