PACKAGECONFIG:append = "eglfs fontconfig gbm gles2 tslib"

PACKAGECONFIG:remove = "examples kde tests wayland x11"

EXTRA_OECMAKE += "-DQT_FEATURE_egl=ON -DFEATURE_opengl=ON"
