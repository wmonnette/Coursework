-- Wesley Monnette (wjm0017)

USE work.bv_arithmetic.ALL;
USE work.dlx_types.ALL;

entity alu is
generic(prop_delay: time := 5 ns);
	port(
		operand1, operand2	: in dlx_word;
		operation		: in alu_operation_code;
		signed			: in bit;
		result			: out dlx_word;
		error			: out error_code
	);
end entity alu;

architecture behavior of alu is

begin
	process_ALU: process(operand1, operand2, operation) is
		variable overFlow	: boolean := false;
		variable result2	: dlx_word;
		variable err		: error_code := "0000";
	begin
		err := "0000";
		case(operation) is
			when "0000" => -- ADD
				bv_addu(operand1, operand2, result2, overFlow);
				if overFlow then
					error <= x"1";
				else
					error <= x"0";
				end if;
				result <= result2;
			when "0001" => -- SUB
				bv_subu(operand1, operand2, result2, overFlow);
				if overFlow then
					error <= x"1";
				else
					error <= x"0";
				end if;
				result <= result2;
			when "0010" => -- AND
				result <= operand1 and operand2;
			when "0011" => -- OR
				result <= operand1 or operand2;
			when "0100" => -- XOR
				result <= operand2 xor operand2;
			when "0101" => -- Not Used
				result <= x"00000000";
			when "0110" => -- SLL (Not Used)
				result <= x"00000000";
			when "0111" => -- SRL (Not Used)
				result <= x"00000000";
			when "1000" => -- SRA (Not Used)
				result <= x"00000000";
			when "1001" => -- SEQ (Not Used)
				result <= x"00000000";
			when "1010" => -- A | SNE (Not Used)
				result <= x"00000000";
			when "1011" => -- B | SLT (Used for SLT)
				if (bv_lt(operand1, operand2)) then
					result <= x"00000001";
				else
					result <= x"00000000";
				end if;
			when "1100" => -- C | SGT (Not Used)
				result <= x"00000000";
			when "1101" => -- D (Not Used)
				result <= x"00000000";
			when "1110" => -- MUL (Used for MUL, MULU)
				bv_mult(operand1, operand2, result2, overFlow);
				if overFlow then
					error <= x"1";
				else
					error <= x"0";
				end if;
				result <= x"00000000";
			when "1111" => -- F | DIV (Not Used)
				result <= x"00000000";
		end case;

	end process process_ALU;

end architecture behavior;
