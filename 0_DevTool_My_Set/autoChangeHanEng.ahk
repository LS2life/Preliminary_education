; vscode에서 vim insert 모드 종료시 한글이면 영문으로 전환
#IfWinActive, ahk_exe Code.exe
$Esc::
    ret := IME_Check("A")
	if %ret% <> 0           ; 1 means IME is in Hangul(Korean) mode now.
        {
            Send, {Esc}
            Send, {vk15}    ; 한글인 경우 Esc키를 입력하고 한영키를 입력해 준다.
    else if %ret% = 0       ; 0 means IME is in English mode now.
        {
            Send, {ESC}         ; 영문인 경우 Esc만 입력.
        }
    Return

#IfWinActive

; 키보드 언어 상태 확인 1이면 한글 0이면 영문
ImeCheck(WinTitle) {
	WinGet,hWnd,ID,%WinTitle%
	Return SendImeControl(ImmGetDefaultIMEWnd(hWnd),0x005,"")
}
SendImeControl(DefaultIMEWnd, wParam, lParam) {
	DetectSave := A_DetectHiddenWindows
	DetectHiddenWindows,ON
	SendMessage 0x283, wParam,lParam,,ahk_id %DefaultIMEWnd%
	if (DetectSave <> A_DetectHiddenWindows)
		DetectHiddenWindows,%DetectSave%
	return ErrorLevel
}
ImmGetDefaultIMEWnd(hWnd) {
	return DllCall("imm32\ImmGetDefaultIMEWnd", Uint,hWnd, Uint)
}
