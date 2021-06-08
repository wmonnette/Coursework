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
# ID         -->   ALPHA+
# ALPHA      -->   a  |  b  | … | z  or
#                  A  |  B  | … | Z
# INT        -->   DIGIT+
# DIGIT      -->   0  |  1  | …  |  9
# WHITESPACE -->   Ruby Whitespace

#
#  Parser Class
#
load "Token.rb"
load "Lexer.rb"
class Parser < Scanner
	$errors = 0
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
         	puts "Expected #{dtype} found #{@lookahead.type}"
      	end
      	consume()
   	end

	def program()
      	while( @lookahead.type != Token::EOF)
        	puts "Entering STMT Rule"
			statement()
      	end
   	end

	def statement()
		if (@lookahead.type == Token::PRINT)
			puts "Found PRINT Token: #{@lookahead.text}"
			match(Token::PRINT)
			puts "Entering EXP Rule"
			exp()
		else
			puts "Entering ASSGN Rule"
			assign()
		end

		puts "Exiting STMT Rule"
	end

	def assign()
		if (@lookahead.type == Token::ID)
			puts "Found ID Token: #{@lookahead.text}"
			match(Token::ID)
			if (@lookahead.type == Token::ASSGN)
				puts "Found ASSGN Token: #{@lookahead.text}"
				match(Token::ASSGN)
				puts "Entering EXP Rule"
			else (@lookahead.type != Token::ASSGN)
				puts "Expected #{Token::ASSGN} found #{@lookahead.text}"
				$errors++
			end
		end

		puts "Exiting ASSGN Rule"
	end

	def exp()
		puts "Entering TERM Rule"
		term()

		puts "Entering ETAIL Rule"
		etail()

		puts "Exiting EXP Rule"
	end

	def etail()
		#write this

		puts "Exiting ETAIL Rule"
	end

	def term()
		puts "Entering FACTOR Rule"
		factor()

		puts "Entering TTAIL Rule"
		ttail()

		puts "Exiting TERM Rule"
	end

	def ttail()
		#write this

		puts "Exiting TTAIL Rule"
	end

	def factor()
		if (@lookahead.type == Token::LPAREN)
				puts "Entering EXP Rule"
				exp()
		elsif (@lookahead.type == Token::INT)
				puts "Found INT Token: #{@lookahead.text}"
		elsif (@lookahead.type == Token::ID)
				puts "Found ID Token: #{@lookahead.text}"
		else
				puts "Expected ( or INT or ID found #{@lookahead.text}"
		end

		puts "Exiting FACTOR Rule"
	end

puts "There were #{$errors} parse errors found."
end
