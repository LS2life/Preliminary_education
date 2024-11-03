
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

#! 캐릭터(스프라이트) 불러오기
character = pygame.image.load("D:/About_IT/Visual Studio Code/ScratchPad/python/python_start/pygame_basic/background/git_spaider.png")
#* 이미지의 크기를 구해옴
character_size = character.get_rect().size
#* 캐릭터의 가로크기
character_width = character_size[0]
#* 캐릭터의 세로크기
character_height = character_size[1]
#* 화면 가로의 절반 크기에 해당하는 곳에 위치
character_x_pos = (screen_width / 2) - (character_width)
#* 화면 세로 크기 가장 아래에 해당하는 곳에 위치
character_y_pos = screen_height - character_height




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

    #* 캐릭터 그리기
    screen.blit(character, (character_x_pos, character_y_pos))
    

    # 게임화면을 다시 그리기
    pygame.display.update()

# pygame 종료
pygame.quit()



















