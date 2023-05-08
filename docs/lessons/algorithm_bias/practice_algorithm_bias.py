"""

Exercises:

1. Modify the function my_top_5 to select the top 5 players based on their overall rating.

2. Create a function select_best_def_off(defensive_players_num, offensive_players_num), the function must receive 2 arguments defensive_players_num, offensive_players_num which are integer that indicates how many defensive and offensive players you want in the team. Your function should sort the data to get the best defensive and offensive players. 
Eg:
select_best_def_off(2, 3) This means my team will have the 2 best defensive players and an the 3 best offensive_players from my list of players
Note: Make sure you do not have duplicate names in your team
and your team has 5 players

"""

import csv

PosName = 0
PosOff = 1
PosDef = 2
PosOver = 3
PosDonation = 4


def read_csv():
    team_list = []
    with open('team.csv', newline='') as csvfile:
        reader = csv.DictReader(csvfile)
        for row in reader:
            team_list.append([
                row['Name'],
                int(row['offensive_rating']),
                int(row['defensive_rating']),
                int(row['overall_rating']),
                int(row['donation']),
            ])
    return team_list

def my_top_5():
    team_list = read_csv()
    top_5 = sorted(team_list, key=lambda x: x[PosDonation],
                   reverse=True)[0:5]
    top_5_name = [x[PosName] for x in top_5]
    return top_5_name

def print_my_team(players, message):
    print(message)
    print(*players)
      
if __name__ == "__main__":
    my_top_5 = my_top_5()
    print_my_team(my_top_5, "Top 5 players for my team:")
