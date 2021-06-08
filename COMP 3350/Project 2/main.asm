; Project 2
; Submitter: Wesley Monnette
; Date: 10/4/2019
; Reads value from an array, adds a value to it, and saves the sum of those two
;	values in a specific register

.386
.model flat,stdcall
.stack 4096
ExitProcess proto, dwExitCode:dword

; Setup input array and shift value
.data
	input byte 1,2,3,4,5,6,7,8
	shift byte 2

.code
	main proc
		; Clear registers to make sure no old values
		mov eax,0
		mov ebx,0
		mov ecx,0
		mov edx,0

		; Setup eax with first and second values
		mov ah, input
		add ah, shift
		mov al, input + 1
		add al, shift

		; Setup ebx with third and fourth values
		mov bh, input + 2
		add bh, shift
		mov bl, input + 3
		add bl, shift

		; Setup ecx with fifth and sisxth values
		mov ch, input + 4
		add ch, shift
		mov cl, input + 5
		add cl, shift

		; Setup edx with seventh and eighth values
		mov dh, input + 6
		add dh, shift
		mov dl, input + 7
		add dl, shift

		; Exit program
		invoke ExitProcess, 0
	main endp
end main