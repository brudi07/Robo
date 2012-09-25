Working on creating a base foundation for a RPG. Hoping to take parts of the Pokemon RPG battle formula and incorporate it into a robot themed game. 

// IDEAS
Robot Themed
3 Bots on a Team
Pokemon Battle Layout
Equipment (Parts)
Bot Programming (Similar to Masteries for Customizability)
Achievements

// CLASS LAYOUTS
Robot Class
-Name
-Level
-HP
-Barrier (Shield)
-Physical Attack
-Energy Attack
-Physical Armor
-Energy Armor
-Speed (Determine who goes first)

Enemy Class extends Robot
-Gold Given
-BaseXP Given

Player Class extends Robot
-TotalGold
-TotalXP
-When level up, all stats gain random boost of 1d3, can pick stat to gain an additional +1d3. (Subject to change)

Battle Class
-Battle while player || enemy health > 0
-Speed determines who goes first
-Turn based
-4 abilities available

Ability Class
-Target
-Attack Type (Physical, Energy)
-Attack Power
-Special Effects
-Crit chance

Part Class
-Chasis (Determines elemental type)
-Head
-Left Arm
-Right Arm
-Body
-Legs
-Battle Chip (Stores level and masteries)
(Rest of parts give elemental attacks, if same type as chasis it has a damage boost.)