<div align="center">

# PetCompanions

![Release](https://img.shields.io/github/v/release/crysscoder/pet-companions?style=flat-square&label=release)
![Java](https://img.shields.io/badge/Java-17-ED8B00?style=flat-square&logo=openjdk&logoColor=white)
![Paper](https://img.shields.io/badge/Paper-1.20.1-2ea44f?style=flat-square)
![Issues](https://img.shields.io/github/issues/crysscoder/pet-companions?style=flat-square)

Paper-плагин питомцев для Minecraft-сервера.

[Release](https://github.com/crysscoder/pet-companions/releases/latest) · [Issues](https://github.com/crysscoder/pet-companions/issues) · [CodeAdapter](https://codeadapter.ru)

</div>

## Что делает

- создаёт питомца игрока через `/pet spawn`
- убирает активного питомца через `/pet despawn`
- хранит активного питомца в сервисе
- поддерживает несколько типов питомцев в коде

## Версии

| Компонент | Версия |
| --- | --- |
| Plugin | `1.0.0` |
| Java | `17` |
| Paper API | `1.20.1-R0.1-SNAPSHOT` |
| Lombok | `1.18.34` |
| Authlib | `3.13.56` |

## Команды

- `/pet spawn`
- `/pet despawn`

## Сборка

```powershell
.\gradlew.bat clean build
```

## Запуск тестового сервера

```powershell
.\gradlew.bat runServer
```
