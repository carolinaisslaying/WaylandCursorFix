# Wayland Cursor Fix


[<img alt="Available on Modrinth" height="56" src="https://cdn.jsdelivr.net/npm/@intergrav/devins-badges@3/assets/cozy/available/modrinth_vector.svg">](https://modrinth.com/project/wayland-cursor-fix)
[<img alt="See me on GitHub" height="56" src="https://cdn.jsdelivr.net/npm/@intergrav/devins-badges@3/assets/cozy/social/github-singular_vector.svg">](https://github.com/carolinaisslaying)
[<img alt="Chat on Discord" height="56" src="https://cdn.jsdelivr.net/npm/@intergrav/devins-badges@3/assets/cozy/social/discord-singular_vector.svg">](https://discord.gg/VVTJhkKc4G)

## What does this mod do?
This mod fixes the cursor on Wayland persisting on the screen after closing modded GUIs such as Ad Astra and Chipped.

When installed, you should not see this occur, and everything should function exactly as intended.

## What environment does this occur in?
I am unsure of every specific environment this occurs in, however, it occurred in mine, so I will explain mine.

1. I am using PrismLauncher to load NeoForge 1.20.1.
2. My system is running Arch Linux and GNOME 50 through Wayland.
3. I had issues with my cursor not being centred when I opened GUIs without any tweaks, so I started using the AUR package [glfw-wayland-minecraft-cursorfix](https://aur.archlinux.org/packages/glfw-wayland-minecraft-cursorfix).
4. I set Prism Launcher to make Minecraft use that system install of GLFW.
5. This fixed my cursor not being centred when opening GUIs, however, it meant my cursor started appearing and staying on my screen after opening certain modded GUIs such as Ad Astra and Chipped.

This mod fixes the latter issue that arises, as stated.
