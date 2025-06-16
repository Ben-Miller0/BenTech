{
    description = "A very basic flake";

    inputs = {
        nixpkgs.url = "github:nixos/nixpkgs?ref=nixos-unstable";
    };

    outputs = { self, nixpkgs }:
        let
            supportedSystems = [ "x86_64-linux" "x86_64-darwin" ];
            forEachSupportedSystem = f: nixpkgs.lib.genAttrs supportedSystems (system: f {
                pkgs = import nixpkgs { inherit system; };
            });
        in
        {
            devShells = forEachSupportedSystem ({ pkgs }:
            let
                xlibs = with pkgs; with xorg; [ libXcursor libXrandr libXxf86vm xrandr ];
            in
            {
                default = pkgs.mkShell {
                    packages = with pkgs; [ jetbrains.idea-community zulu21 ] ++ xlibs;
                    LD_LIBRARY_PATH = "${pkgs.lib.makeLibraryPath xlibs }";
                    JAVA_8_HOME = "${pkgs.zulu8}";
                    JAVA_21_HOME = "${pkgs.zulu21}";
                };
            });
    };
}
