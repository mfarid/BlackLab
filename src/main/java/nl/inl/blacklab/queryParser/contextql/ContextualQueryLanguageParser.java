/* Generated By:JavaCC: Do not edit this line. ContextualQueryLanguageParser.java */
package nl.inl.blacklab.queryParser.contextql;

import nl.inl.blacklab.search.CompleteQuery;
import nl.inl.blacklab.search.Searcher;
import nl.inl.blacklab.search.indexstructure.IndexStructure;

@SuppressWarnings("all")

public class ContextualQueryLanguageParser implements ContextualQueryLanguageParserConstants {

    public static void main(String[] args) throws nl.inl.blacklab.queryParser.contextql.ParseException
    {
                ContextualQueryLanguageParser parser = new ContextualQueryLanguageParser(new java.io.StringReader(args[0]));
                parser.query();
    }

    /**
     * Parse a Contextual Query Language query.
     
     * @param searcher our index
     * @param query our query
     * @return the parsed query
     */
    public static CompleteQuery parse(Searcher searcher, String query) throws nl.inl.blacklab.queryParser.contextql.ParseException
    {
        ContextualQueryLanguageParser parser = new ContextualQueryLanguageParser(new java.io.StringReader(query));
        parser.setSearcher(searcher);
        return parser.query();
    }

    private String chopEnds(String input)
    {
        if (input.length() >= 2)
                return input.substring(1, input.length() - 1);
        throw new RuntimeException();
    }

    private Searcher searcher;

    public void setSearcher(Searcher searcher) {
        this.searcher = searcher;
    }

    private String defaultProperty = "contents.word";

    public void setDefaultProperty(IndexStructure structure, String fieldName) {
        defaultProperty = structure.getComplexFieldDesc(fieldName).getMainProperty().getName();
    }

    public void setDefaultProperty(String property) {
        defaultProperty = property;
    }

    public String getDefaultProperty() {
        return defaultProperty;
    }

// --- Grammar rules start here --- 

/* a query */
  final public CompleteQuery query() throws ParseException {
        CompleteQuery a = null;
    a = queryInternal();
    jj_consume_token(0);
        {if (true) return a;}
    throw new Error("Missing return statement in function");
  }

  final public CompleteQuery queryInternal() throws ParseException {
        CompleteQuery a = null;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case 13:
      scope();
      a = queryInternal();
        {if (true) return a;}
      break;
    case AND:
    case OR:
    case NOT:
    case PROX:
    case IDENTIFIER:
    case STRING:
    case 15:
      a = scopedClause();
        {if (true) return a;}
      break;
    default:
      jj_la1[0] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
  }

  final public void scope() throws ParseException {
    jj_consume_token(13);
    if (jj_2_1(2)) {
      prefix();
      jj_consume_token(14);
    } else {
      ;
    }
    uri();
  }

  final public String prefix() throws ParseException {
    String a;
    a = term();
                {if (true) return a;}
    throw new Error("Missing return statement in function");
  }

  final public String uri() throws ParseException {
    String a;
    a = term();
                {if (true) return a;}
    throw new Error("Missing return statement in function");
  }

  final public CompleteQuery scopedClause() throws ParseException {
    CompleteQuery a, b = null;
    String op = null;
    a = searchClause();
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case AND:
    case OR:
    case NOT:
    case PROX:
      op = booleanGroup();
      b = scopedClause();
      break;
    default:
      jj_la1[1] = jj_gen;
      ;
    }
        if (op == null)
            {if (true) return a;}
        {if (true) return ContextQlParseUtils.combineClauses(a, op, b);}
    throw new Error("Missing return statement in function");
  }

  final public String booleanGroup() throws ParseException {
    String a;
    a = ruleBoolean();
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case 21:
      modifierList();
      break;
    default:
      jj_la1[2] = jj_gen;
      ;
    }
                                           {if (true) return a;}
    throw new Error("Missing return statement in function");
  }

  final public String ruleBoolean() throws ParseException {
    Token a;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case AND:
      a = jj_consume_token(AND);
                     {if (true) return a.toString();}
      break;
    case OR:
      a = jj_consume_token(OR);
                     {if (true) return a.toString();}
      break;
    case NOT:
      a = jj_consume_token(NOT);
                     {if (true) return a.toString();}
      break;
    case PROX:
      a = jj_consume_token(PROX);
                     {if (true) return a.toString();}
      break;
    default:
      jj_la1[3] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
  }

  final public CompleteQuery searchClause() throws ParseException {
    CompleteQuery tp;
    String i = null, r = null, t;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case 15:
      jj_consume_token(15);
      tp = queryInternal();
      jj_consume_token(16);
                                                  {if (true) return tp;}
      break;
    case AND:
    case OR:
    case NOT:
    case PROX:
    case IDENTIFIER:
    case STRING:
      if (jj_2_2(2)) {
        i = index();
        r = relation();
      } else {
        ;
      }
      t = searchTerm();
                                                              {if (true) return ContextQlParseUtils.clause(searcher, i, r, t, defaultProperty);}
      break;
    default:
      jj_la1[4] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
  }

  final public String index() throws ParseException {
    String a;
    a = term();
                {if (true) return a;}
    throw new Error("Missing return statement in function");
  }

  final public String relation() throws ParseException {
    String a;
    a = comparitor();
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case 21:
      modifierList();
      break;
    default:
      jj_la1[5] = jj_gen;
      ;
    }
        {if (true) return a;}
    throw new Error("Missing return statement in function");
  }

  final public String comparitor() throws ParseException {
    String a;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case 13:
    case 14:
    case 17:
    case 18:
    case 19:
    case 20:
      a = comparitorSymbol();
                          {if (true) return a;}
      break;
    case IDENTIFIER:
    case STRING:
      a = namedComparitor();
                          {if (true) return a;}
      break;
    default:
      jj_la1[6] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
  }

  final public String comparitorSymbol() throws ParseException {
    Token a;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case 14:
      a = jj_consume_token(14);
             {if (true) return a.toString();}
      break;
    case 13:
      a = jj_consume_token(13);
             {if (true) return a.toString();}
      break;
    case 17:
      a = jj_consume_token(17);
             {if (true) return a.toString();}
      break;
    case 18:
      a = jj_consume_token(18);
             {if (true) return a.toString();}
      break;
    case 19:
      a = jj_consume_token(19);
             {if (true) return a.toString();}
      break;
    case 20:
      a = jj_consume_token(20);
             {if (true) return a.toString();}
      break;
    default:
      jj_la1[7] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
  }

  final public String namedComparitor() throws ParseException {
    String a;
    a = identifier();
                     {if (true) return a;}
    throw new Error("Missing return statement in function");
  }

  final public void modifierList() throws ParseException {
    if (jj_2_3(2)) {
      jj_consume_token(21);
      modifier();
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case 21:
        modifierList();
        break;
      default:
        jj_la1[8] = jj_gen;
        ;
      }
    } else {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case 21:
        jj_consume_token(21);
        modifierList();
        break;
      default:
        jj_la1[9] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    }
  }

  final public void modifier() throws ParseException {
    modifierName();
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case 13:
    case 14:
    case 17:
    case 18:
    case 19:
    case 20:
      comparitorSymbol();
      modifierValue();
      break;
    default:
      jj_la1[10] = jj_gen;
      ;
    }
      {if (true) throw new UnsupportedOperationException("Relation modifiers not supported yet!");}
  }

  final public String modifierName() throws ParseException {
    String a;
    a = term();
                {if (true) return a;}
    throw new Error("Missing return statement in function");
  }

  final public String modifierValue() throws ParseException {
    String a;
    a = term();
                {if (true) return a;}
    throw new Error("Missing return statement in function");
  }

  final public String searchTerm() throws ParseException {
    String a;
    a = term();
                {if (true) return a;}
    throw new Error("Missing return statement in function");
  }

  final public String term() throws ParseException {
    String a;
    Token t;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case IDENTIFIER:
    case STRING:
      a = identifier();
                     {if (true) return a;}
      break;
    case AND:
      t = jj_consume_token(AND);
                     {if (true) return t.toString();}
      break;
    case OR:
      t = jj_consume_token(OR);
                     {if (true) return t.toString();}
      break;
    case NOT:
      t = jj_consume_token(NOT);
                     {if (true) return t.toString();}
      break;
    case PROX:
      t = jj_consume_token(PROX);
                     {if (true) return t.toString();}
      break;
    default:
      jj_la1[11] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
  }

  final public String identifier() throws ParseException {
    Token a;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case IDENTIFIER:
      a = jj_consume_token(IDENTIFIER);
                      {if (true) return a.toString();}
      break;
    case STRING:
      a = jj_consume_token(STRING);
                      {if (true) return chopEnds(a.toString());}
      break;
    default:
      jj_la1[12] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
  }

  final private boolean jj_2_1(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_1(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(0, xla); }
  }

  final private boolean jj_2_2(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_2(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(1, xla); }
  }

  final private boolean jj_2_3(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_3(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(2, xla); }
  }

  final private boolean jj_3_3() {
    if (jj_scan_token(21)) return true;
    if (jj_3R_4()) return true;
    return false;
  }

  final private boolean jj_3R_12() {
    if (jj_scan_token(PROX)) return true;
    return false;
  }

  final private boolean jj_3R_11() {
    if (jj_scan_token(NOT)) return true;
    return false;
  }

  final private boolean jj_3R_2() {
    if (jj_3R_5()) return true;
    return false;
  }

  final private boolean jj_3R_10() {
    if (jj_scan_token(OR)) return true;
    return false;
  }

  final private boolean jj_3R_9() {
    if (jj_scan_token(AND)) return true;
    return false;
  }

  final private boolean jj_3R_5() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_8()) {
    jj_scanpos = xsp;
    if (jj_3R_9()) {
    jj_scanpos = xsp;
    if (jj_3R_10()) {
    jj_scanpos = xsp;
    if (jj_3R_11()) {
    jj_scanpos = xsp;
    if (jj_3R_12()) return true;
    }
    }
    }
    }
    return false;
  }

  final private boolean jj_3R_8() {
    if (jj_3R_15()) return true;
    return false;
  }

  final private boolean jj_3R_17() {
    if (jj_3R_15()) return true;
    return false;
  }

  final private boolean jj_3_2() {
    if (jj_3R_2()) return true;
    if (jj_3R_3()) return true;
    return false;
  }

  final private boolean jj_3R_1() {
    if (jj_3R_5()) return true;
    return false;
  }

  final private boolean jj_3R_25() {
    if (jj_scan_token(20)) return true;
    return false;
  }

  final private boolean jj_3_1() {
    if (jj_3R_1()) return true;
    if (jj_scan_token(14)) return true;
    return false;
  }

  final private boolean jj_3R_24() {
    if (jj_scan_token(19)) return true;
    return false;
  }

  final private boolean jj_3R_23() {
    if (jj_scan_token(18)) return true;
    return false;
  }

  final private boolean jj_3R_22() {
    if (jj_scan_token(17)) return true;
    return false;
  }

  final private boolean jj_3R_21() {
    if (jj_scan_token(13)) return true;
    return false;
  }

  final private boolean jj_3R_20() {
    if (jj_scan_token(14)) return true;
    return false;
  }

  final private boolean jj_3R_16() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_20()) {
    jj_scanpos = xsp;
    if (jj_3R_21()) {
    jj_scanpos = xsp;
    if (jj_3R_22()) {
    jj_scanpos = xsp;
    if (jj_3R_23()) {
    jj_scanpos = xsp;
    if (jj_3R_24()) {
    jj_scanpos = xsp;
    if (jj_3R_25()) return true;
    }
    }
    }
    }
    }
    return false;
  }

  final private boolean jj_3R_14() {
    if (jj_3R_17()) return true;
    return false;
  }

  final private boolean jj_3R_6() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_13()) {
    jj_scanpos = xsp;
    if (jj_3R_14()) return true;
    }
    return false;
  }

  final private boolean jj_3R_13() {
    if (jj_3R_16()) return true;
    return false;
  }

  final private boolean jj_3R_7() {
    if (jj_3R_5()) return true;
    return false;
  }

  final private boolean jj_3R_19() {
    if (jj_scan_token(STRING)) return true;
    return false;
  }

  final private boolean jj_3R_4() {
    if (jj_3R_7()) return true;
    return false;
  }

  final private boolean jj_3R_18() {
    if (jj_scan_token(IDENTIFIER)) return true;
    return false;
  }

  final private boolean jj_3R_15() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_18()) {
    jj_scanpos = xsp;
    if (jj_3R_19()) return true;
    }
    return false;
  }

  final private boolean jj_3R_3() {
    if (jj_3R_6()) return true;
    return false;
  }

  public ContextualQueryLanguageParserTokenManager token_source;
  JavaCharStream jj_input_stream;
  public Token token, jj_nt;
  private int jj_ntk;
  private Token jj_scanpos, jj_lastpos;
  private int jj_la;
  public boolean lookingAhead = false;
  private boolean jj_semLA;
  private int jj_gen;
  final private int[] jj_la1 = new int[13];
  static private int[] jj_la1_0;
  static {
      jj_la1_0();
   }
   private static void jj_la1_0() {
      jj_la1_0 = new int[] {0xbf80,0x780,0x200000,0x780,0x9f80,0x200000,0x1e7800,0x1e6000,0x200000,0x200000,0x1e6000,0x1f80,0x1800,};
   }
  final private JJCalls[] jj_2_rtns = new JJCalls[3];
  private boolean jj_rescan = false;
  private int jj_gc = 0;

  public ContextualQueryLanguageParser(java.io.InputStream stream) {
     this(stream, null);
  }
  public ContextualQueryLanguageParser(java.io.InputStream stream, String encoding) {
    try { jj_input_stream = new JavaCharStream(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source = new ContextualQueryLanguageParserTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 13; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  public void ReInit(java.io.InputStream stream) {
     ReInit(stream, null);
  }
  public void ReInit(java.io.InputStream stream, String encoding) {
    try { jj_input_stream.ReInit(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 13; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  public ContextualQueryLanguageParser(java.io.Reader stream) {
    jj_input_stream = new JavaCharStream(stream, 1, 1);
    token_source = new ContextualQueryLanguageParserTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 13; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  public void ReInit(java.io.Reader stream) {
    jj_input_stream.ReInit(stream, 1, 1);
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 13; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  public ContextualQueryLanguageParser(ContextualQueryLanguageParserTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 13; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  public void ReInit(ContextualQueryLanguageParserTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 13; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  final private Token jj_consume_token(int kind) throws ParseException {
    Token oldToken;
    if ((oldToken = token).next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    if (token.kind == kind) {
      jj_gen++;
      if (++jj_gc > 100) {
        jj_gc = 0;
        for (int i = 0; i < jj_2_rtns.length; i++) {
          JJCalls c = jj_2_rtns[i];
          while (c != null) {
            if (c.gen < jj_gen) c.first = null;
            c = c.next;
          }
        }
      }
      return token;
    }
    token = oldToken;
    jj_kind = kind;
    throw generateParseException();
  }

  static private final class LookaheadSuccess extends java.lang.Error { }
  final private LookaheadSuccess jj_ls = new LookaheadSuccess();
  final private boolean jj_scan_token(int kind) {
    if (jj_scanpos == jj_lastpos) {
      jj_la--;
      if (jj_scanpos.next == null) {
        jj_lastpos = jj_scanpos = jj_scanpos.next = token_source.getNextToken();
      } else {
        jj_lastpos = jj_scanpos = jj_scanpos.next;
      }
    } else {
      jj_scanpos = jj_scanpos.next;
    }
    if (jj_rescan) {
      int i = 0; Token tok = token;
      while (tok != null && tok != jj_scanpos) { i++; tok = tok.next; }
      if (tok != null) jj_add_error_token(kind, i);
    }
    if (jj_scanpos.kind != kind) return true;
    if (jj_la == 0 && jj_scanpos == jj_lastpos) throw jj_ls;
    return false;
  }

  final public Token getNextToken() {
    if (token.next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    jj_gen++;
    return token;
  }

  final public Token getToken(int index) {
    Token t = lookingAhead ? jj_scanpos : token;
    for (int i = 0; i < index; i++) {
      if (t.next != null) t = t.next;
      else t = t.next = token_source.getNextToken();
    }
    return t;
  }

  final private int jj_ntk() {
    if ((jj_nt=token.next) == null)
      return (jj_ntk = (token.next=token_source.getNextToken()).kind);
    else
      return (jj_ntk = jj_nt.kind);
  }

  private java.util.Vector jj_expentries = new java.util.Vector();
  private int[] jj_expentry;
  private int jj_kind = -1;
  private int[] jj_lasttokens = new int[100];
  private int jj_endpos;

  private void jj_add_error_token(int kind, int pos) {
    if (pos >= 100) return;
    if (pos == jj_endpos + 1) {
      jj_lasttokens[jj_endpos++] = kind;
    } else if (jj_endpos != 0) {
      jj_expentry = new int[jj_endpos];
      for (int i = 0; i < jj_endpos; i++) {
        jj_expentry[i] = jj_lasttokens[i];
      }
      boolean exists = false;
      for (java.util.Enumeration e = jj_expentries.elements(); e.hasMoreElements();) {
        int[] oldentry = (int[])(e.nextElement());
        if (oldentry.length == jj_expentry.length) {
          exists = true;
          for (int i = 0; i < jj_expentry.length; i++) {
            if (oldentry[i] != jj_expentry[i]) {
              exists = false;
              break;
            }
          }
          if (exists) break;
        }
      }
      if (!exists) jj_expentries.addElement(jj_expentry);
      if (pos != 0) jj_lasttokens[(jj_endpos = pos) - 1] = kind;
    }
  }

  public ParseException generateParseException() {
    jj_expentries.removeAllElements();
    boolean[] la1tokens = new boolean[22];
    for (int i = 0; i < 22; i++) {
      la1tokens[i] = false;
    }
    if (jj_kind >= 0) {
      la1tokens[jj_kind] = true;
      jj_kind = -1;
    }
    for (int i = 0; i < 13; i++) {
      if (jj_la1[i] == jj_gen) {
        for (int j = 0; j < 32; j++) {
          if ((jj_la1_0[i] & (1<<j)) != 0) {
            la1tokens[j] = true;
          }
        }
      }
    }
    for (int i = 0; i < 22; i++) {
      if (la1tokens[i]) {
        jj_expentry = new int[1];
        jj_expentry[0] = i;
        jj_expentries.addElement(jj_expentry);
      }
    }
    jj_endpos = 0;
    jj_rescan_token();
    jj_add_error_token(0, 0);
    int[][] exptokseq = new int[jj_expentries.size()][];
    for (int i = 0; i < jj_expentries.size(); i++) {
      exptokseq[i] = (int[])jj_expentries.elementAt(i);
    }
    return new ParseException(token, exptokseq, tokenImage);
  }

  final public void enable_tracing() {
  }

  final public void disable_tracing() {
  }

  final private void jj_rescan_token() {
    jj_rescan = true;
    for (int i = 0; i < 3; i++) {
    try {
      JJCalls p = jj_2_rtns[i];
      do {
        if (p.gen > jj_gen) {
          jj_la = p.arg; jj_lastpos = jj_scanpos = p.first;
          switch (i) {
            case 0: jj_3_1(); break;
            case 1: jj_3_2(); break;
            case 2: jj_3_3(); break;
          }
        }
        p = p.next;
      } while (p != null);
      } catch(LookaheadSuccess ls) { }
    }
    jj_rescan = false;
  }

  final private void jj_save(int index, int xla) {
    JJCalls p = jj_2_rtns[index];
    while (p.gen > jj_gen) {
      if (p.next == null) { p = p.next = new JJCalls(); break; }
      p = p.next;
    }
    p.gen = jj_gen + xla - jj_la; p.first = token; p.arg = xla;
  }

  static final class JJCalls {
    int gen;
    Token first;
    int arg;
    JJCalls next;
  }

}