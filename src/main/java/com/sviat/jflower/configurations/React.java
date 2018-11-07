package com.sviat.jflower.configurations;

import jdk.nashorn.api.scripting.NashornScriptEngine;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.IOException;

@Component
public class React {
    @Value("classpath:static/nashorn-polyfill.js")
    private Resource nashornPolyfillFile;
    @Value("classpath:static/bundle.js")
    private Resource bundleJsFile;

    public React() {
    }

    public String renderEntryPoint() throws ScriptException, IOException {
        NashornScriptEngine nashornScriptEngine = this.getNashornScriptEngine();

        try {
            Object html = nashornScriptEngine.invokeFunction("renderServer", new Object[0]);
            return String.valueOf(html);
        } catch (Exception var3) {
            var3.printStackTrace();
            throw  new RuntimeException("Error! Failed to render react component!", var3);
        }
    }

    private NashornScriptEngine getNashornScriptEngine() throws ScriptException, IOException {
        NashornScriptEngine nashornScriptEngine = (NashornScriptEngine)(new ScriptEngineManager()).getEngineByName("nashorn");
        nashornScriptEngine.eval("load ('" + this.nashornPolyfillFile.getFile().getCanonicalPath() + "')");
        nashornScriptEngine.eval("load ('" + this.bundleJsFile.getFile().getCanonicalPath() + "')");
        return nashornScriptEngine;
    }
}
