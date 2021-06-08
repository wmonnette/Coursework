# https://www.cs.rochester.edu/~brown/173/readings/05_grammars.txt
#
#  "TINY" Grammar
#
# PGM        -->   STMT+
# STMT       -->   ASSIGN   |   "print"  EXP
# ASSIGN     -->   ID  "="  EXP
# EXP        -->   TERM   ETAIL
# ETAIL      -->   "+" TERM   ETAIL  | "-" TERM   ETAIL | EPSILON
# TERM       -->   FACTOR  TTAIL
# TTAIL      -->   "*" FACTOR TTAIL  | "/" FACTOR TTAIL | EPSILON
# FACTOR     -->   "(" EXP ")" | INT | ID
# EPSILON    -->   ""
# ID         -->   ALPHA+
# ALPHA      -->   a  |  b  | … | z  or
#                  A  |  B  | … | Z
# INT        -->   DIGIT+
# DIGIT      -->   0  |  1  | …  |  9
# WHITESPACE -->   Ruby Whitespace

#
#  Parser Class
#
load "Lexer.rb"
class Parser < Scanner

    def initialize(filename)
        super(filename)
        consume()
    end

    def consume()
        @lookahead = nextToken()
        while(@lookahead.type == Token::WS)
            @lookahead = nextToken()
        end
    end

    def match(dtype)
        if (@lookahead.type != dtype)
            puts "Expected #{dtype} found #{@lookahead.text}"
			@errors_found+=1
        end
        consume()
    end

    def program()
    	@errors_found = 0

		p = AST.new(Token.new("program","program"))

	    while( @lookahead.type != Token::EOF)
            p.addChild(statement())
        end

        puts "There were #{@errors_found} parse errors found."

		return p
    end

    def statement()
		stmt = AST.new(Token.new("statement","statement"))
        if (@lookahead.type == Token::PRINT)
			stmt = AST.new(@lookahead)
            match(Token::PRINT)
            stmt.addChild(exp())
        else
            stmt = assign()
        end
		return stmt
    end

    def exp()
        term()
        etail()
    end

    def term()
        factor()
        ttail()
    end

    def factor()
        if (@lookahead.type == Token::LPAREN)
            match(Token::LPAREN)
            exp()
            if (@lookahead.type == Token::RPAREN)
                match(Token::RPAREN)
            else
				match(Token::RPAREN)
            end
        elsif (@lookahead.type == Token::INT)
            match(Token::INT)
        elsif (@lookahead.type == Token::ID)
            match(Token::ID)
        else
            puts "Expected ( or INT or ID found #{@lookahead.text}"
            @errors_found+=1
            consume()
        end
		return fct
    end

    def ttail()
      ttail = AST.new(Token.new("ttail","ttail"))
        if (@lookahead.type == Token::MULTOP)
            multok = AST.new(@lookahead)
            ttail.addChild(multok)
            match(Token::MULTOP)
            ttail.addChild(factor())
            ttail.addChild(ttail())
        elsif (@lookahead.type == Token::DIVOP)
            divtok = AST.new(@lookahead)
            ttail.addChild(divtok)
            match(Token::DIVOP)
            ttail.addChild(factor())
            ttail.addChild(ttail())
		else
			return ttail
        end
    end

    def etail()
      etail = AST.new(Token.new("etail","etail"))
        if (@lookahead.type == Token::ADDOP)
            addtok = AST.new(@lookahead)
            etail.addChild(addtok)
            match(Token::ADDOP)
            etail.addChild(term())
            etail.addChild(etail())
        elsif (@lookahead.type == Token::SUBOP)
            subtok = AST.new(@lookahead)
            etail.addChild(subtok)
            match(Token::SUBOP)
            etail.addChild(term())
            etail.addChild(etail())
		else
			return etail
        end
    end

    def assign()
        assgn = AST.new(Token.new("assignment","assignment"))
		if (@lookahead.type == Token::ID)
			idtok = AST.new(@lookahead)
			match(Token::ID)
			if (@lookahead.type == Token::ASSGN)
				assgn = AST.new(@lookahead)
				assgn.addChild(idtok)
            	match(Token::ASSGN)
				assgn.addChild(exp())
        	else
				match(Token::ASSGN)
			end
		else
			match(Token::ID)
        end
		return assgn
	end
end
