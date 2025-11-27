package com.example.SmartChef_Backend.mapper;

import com.example.SmartChef_Backend.dto.UsuarioDTO;
import com.example.SmartChef_Backend.modelos.Usuarios;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface UsuariosMapper {

    // ENTITY -> DTO
    @Mappings({
            @Mapping(target = "contrasena", source = "contrasena"),
            @Mapping(target = "preferencia", source = "preferencia"),
            @Mapping(target = "fotoPerfil", source = "fotoPerfilUsuario.id"),
            @Mapping(target = "coleccionesId", expression = "java(usuario.getColecciones().stream().map(c -> c.getId()).collect(Collectors.toSet()))"),
            @Mapping(target = "listaComprasId", expression = "java(usuario.getListaCompras().stream().map(l -> l.getId()).collect(Collectors.toSet()))")
    })
    UsuarioDTO usuarioToUsuarioDTO(Usuarios usuario);

    // DTO -> ENTITY
    @Mappings({
            @Mapping(target = "contrasena", source = "password"),
            @Mapping(target = "preferencia", expression = "java(UsuarioDTOtoEnum(usuarioDTO.getPreferencia()))"),
            @Mapping(target = "fotoPerfilUsuario", ignore = true), // se maneja en servicio
            @Mapping(target = "colecciones", ignore = true),
            @Mapping(target = "listaCompras", ignore = true),
            @Mapping(target = "fechaRegistro", ignore = true) // se setea al guardar
    })
    Usuarios usuarioDTOToUsuario(UsuarioDTO usuarioDTO);

    // Método helper para convertir String -> Enum
    default Usuarios.PreferenciaAlimentaria UsuarioDTOtoEnum(String pref) {
        if (pref == null) return null;
        try {
            return Usuarios.PreferenciaAlimentaria.valueOf(pref);
        } catch (IllegalArgumentException e) {
            return null;
        }
    }
}
