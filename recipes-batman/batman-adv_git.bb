SUMMARY = "B.A.T.M.A.N. Advanced Kernel Module"
DESCRIPTION = "Kernel module providing batman-adv mesh networking capabilities"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://../COPYING;md5=d32239bcb673463ab874e80d47fae504"

EXTRA_OEMAKE += "KERNELPATH=${STAGING_KERNEL_DIR}"
MODULES_INSTALL_TARGET = "install"

inherit module

RDEPENDS_${PN} = " kernel-module-libcrc32c kernel-module-bridge"
S = "${WORKDIR}/git"

SRCREV = "7ce27179473a1a09d199d4109fcfa7ff91882009"
SRC_URI = "git://git.open-mesh.org/batman-adv.git \
           file://COPYING \
	   file://0001-batman-adv-Allow-to-disable-depmod.patch \
	   file://0002-batman-adv-Fix-timer_setup-on-4.12.28.patch \
          "

PV = "_git${SRCREV}"

# The inherit of module.bbclass will automatically name module packages with
# "kernel-module-" prefix as required by the oe-core build environment.
KERNEL_MODULE_AUTOLOAD += " libcrc32c batman-adv"
