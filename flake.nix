{
  description = "";
  inputs.nixpkgs.url = "github:NixOS/nixpkgs/nixos-unstable";

  outputs = {
    self,
    nixpkgs,
  }: let
    supportedSystems = ["x86_64-linux" "x86_64-darwin" "aarch64-linux" "aarch64-darwin"];
    forAllSystems = nixpkgs.lib.genAttrs supportedSystems;
    nixpkgsFor = forAllSystems (system:
      import nixpkgs {
        inherit system;
        overlays = [
        ];
      });
  in {
    formatter = forAllSystems (system: (nixpkgsFor.${system}).alejandra);

    devShells = forAllSystems (system:
      with nixpkgsFor.${system}; {
        default = mkShellNoCC {
          packages = [
            bazel_7
            openjdk21
            gcc
          ];
        };
      });
  };
}
