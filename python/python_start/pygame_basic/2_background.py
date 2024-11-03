
import pygame

# 초기화 
pygame.init()

# 화면크기 설정
# 가로크기
screen_width = 960
# 세로크기
screen_height = 1280
screen = pygame.display.set_mode((screen_height, screen_width))

# 화면 타이틀 설정
# 게임 이름
pygame.display.set_caption("SS Game")

# 배경 이미지 불러오기
background = pygame.image.load("D:/About_IT/Visual Studio Code/ScratchPad/python/python_start/pygame_basic/background/war_machine.png")

# 이벤트 루프
# 게임이 진행중인가?
running = True
while running:
    # 어떤 이벤트가 발생하였는가?
    for event in pygame.event.get():
        # 창이 닫히는 이벤트가 발생하였는가?
        if event.type == pygame.QUIT:
            # 진행중이 아님.
            running = False

    # 배경그리기
    screen.blit(background, (0,0))
    # screen.fill((0,0,255))

    # 게임화면을 다시 그리기
    pygame.display.update()

# pygame 종료
pygame.quit()
