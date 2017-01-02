SUMMARY = "B.A.T.M.A.N. Advanced Kernel Module"
DESCRIPTION = "Kernel module providing batman-adv mesh networking capabilities"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://../COPYING;md5=d32239bcb673463ab874e80d47fae504"

inherit module

RDEPENDS_${PN} = " kernel-module-libcrc32c kernel-module-bridge"
S = "${WORKDIR}/git"

SRCREV = "a43826180ec48f1fadc40739ca44196bdbbd10a2"
SRC_URI = "git://git.open-mesh.org/batman-adv.git \
           file://COPYING \
           file://0000_batmav-adv_makefile-KERNELPATH.patch \
          "

PV = "_git${SRCREV}"

# The inherit of module.bbclass will automatically name module packages with
# "kernel-module-" prefix as required by the oe-core build environment.
KERNEL_MODULE_AUTOLOAD += " libcrc32c batman-adv"
