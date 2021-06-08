; Project 3
; Submitter: Wesley Monnette
; Date: 10/25/2019

.386
.model flat,stdcall
.stack 4096
ExitProcess proto, dwExitCode:dword

.data
	shift dword 3
	input byte 5,0ah,3,6,och
	output byte lengthof input dup(?)

.code
	main proc
		
		; This loop will iterate length - shift times
		; (this loop will place the 'non-wraped' values)
		; Start reading from input at 0
		; Start writing at shift
		mov ecx, lengthof input
		mov esi,0
		mov edi,0
		mov eax,0
		l1:
			; Move the value from input to al
			mov al,input

			; Move the value from al into output
			mov output, al
			
			; Increment the input index
			inc esi

			; Increment the output index
			inc edi

			loop l1

		; This loop will iterate shift times
		; Start writing at index 0
		; Start reading at index length - shift
		; (this loop will place the 'wrapped' values)
		mov ecx, lengthof input
		mov esi,0
		mov edi,0
		mov eax,0
		l2:
			; Move the value from input into al
			mov al,input

			; Move the value from al into output 
			mov output, al

			; Increment the input index
			inc esi

			; Increment the output index
			inc edi
			loop l2

		; loop 3
		; does output stuff
		mov ecx, lengthof output
		mov edi, 0
		mov eax, 0
		l3:
			mov al, output[edi]
			call WriteInt
			inc edi
			loop l3

		invoke ExitProcess, 0
	main endp
end main